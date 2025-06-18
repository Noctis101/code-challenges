import psutil

def is_enough_ram(required_mb: float, margin_mb: float = 0.0):
    """
    Check if the system has enough *usable* memory including a buffer margin.
    """
    available = psutil.virtual_memory().available
    total = psutil.virtual_memory().total
    percent = psutil.virtual_memory().percent

    print(f"Available: {available} bytes ({available / 1024**2:.2f} MB)")
    print(f"Total: {total} bytes ({total / 1024**2:.2f} MB)")
    print(f"Used %: {percent}")

    required_bytes = (required_mb + margin_mb) * 1024 * 1024

    if available >= required_bytes:
        return True
    return False

if __name__ == "__main__":
    print("Enough RAM?", is_enough_ram(1024, margin_mb=256))