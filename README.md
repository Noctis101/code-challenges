# Code Challenges
This is a repository for accepting submissions for coding challenges. All submissions will be accepted by a pull request containing your name and the number of the challenge, with the submission in the submissions folder of the challenge.

# Challenge #2 — Design Challenge

## Scenario

You're designing a **Backend-for-Frontend (BFF)** for a financial app. The BFF must expose a **unified API** to return **normalized transaction data**, regardless of transaction type or the service that initiated it.

### Each transaction:

* Is **initiated by a different microservice**
* Has a **unique payload structure**
* Is stored in that service’s own **isolated database**
* Is centrally referenced in a **Transaction Log Service**, which provides:

  * `transactionId`
  * `type`
  * `timestamp`
  * `sourceService`

---

## Objective

Design a **lightweight solution** that satisfies the following responsibilities **without requiring fully functional services or real databases**.

The BFF must:

1. **Retrieve recent transactions** from the Transaction Log Service
2. **Expose a unified endpoint** that returns normalized general transaction data
3. **Expose a second endpoint** that returns **detailed information** about a specific transaction based on its `type`

---

## Required Output

> The BFF should expose two endpoints:

### `/transactions`

Returns a paginated list of general transaction info:

```json
{
  "id": "txn-1",
  "type": "bill-payment",
  "amount": 100.0,
  "timestamp": "2025-05-10T10:30:00Z",
  "source": "BillPayService"
}
```

### `/transactions/:id`

Returns the full normalized transaction detail:

```json
{
  "id": "txn-1",
  "type": "bill-payment",
  "amount": 100.0,
  "timestamp": "2025-05-10T10:30:00Z",
  "source": "BillPayService",
  "details": {
    "biller": "WaterCo",
    "referenceNumber": "REF123456"
  }
}
```

You may simulate all dependent services (e.g., Commerce Service, Terminal Service) with:

* Stubbed functions
* Static data
* In-memory mocks

---

## Transaction Types and Their Fields

| Type            | Source Service   | `details` Payload Fields                |
| --------------- | ---------------- | --------------------------------------- |
| Mobile Top-up   | Commerce Service | `carrier`, `topUpAmount`                |
| POS Transaction | Commerce Service | `merchantName`, `location`, `method`    |
| Online Purchase | Commerce Service | `merchantName`, `location`, `method`    |
| Bill Payment    | Bill Pay Service | `biller`, `referenceNumber`             |
| P2P Transfer    | Profile Service  | `senderName`, `receiverName`            |
| Loan Repayment  | Credit Service   | `payment`, `balance`, `referenceNumber` |
| ABM Deposit     | Terminal Service | `location`, `abmNumber`                 |
| ABM Withdrawal  | Terminal Service | `location`, `abmNumber`                 |

---

## QA Requirements

QA Engineers should provide:

* A **test strategy** (functional, edge case, negative scenarios)
* A sample **test case table**
* A few **sample test cases** using a tool of choice (Postman, REST-assured, etc.)
* Optional: basic automation snippet or pseudocode

---

## Developer Requirements

Developers should provide:

* A **minimal code snippet or demo** of how their BFF handles:

  * Normalizing the transaction detail
  * Determining the correct service to fetch from and/or correct transaction to retrieve
* A brief **architecture diagram or flowchart**
* An optional OpenAPI/YAML definition of the BFF endpoint(s)
* You may not modify/extend the source services, but you have freedom otherwise.

---

## Submission Expectations

| Component           | Format           | Required |
| ------------------- | ---------------- | -------- |
| High-level design   | Markdown/Diagram | ✅        |
| Two API definitions | Code or OpenAPI  | ✅        |
| Sample output JSONs | JSON files       | ✅        |
| Mock service logic  | In-code or stub  | ✅        |
| QA test plan        | Markdown         | ✅        |
| Sample test cases   | Table or tool    | ✅        |

---

## Time Constraints

* Expected time investment: **5–10 hours**
* Focus is on **clarity of design and testability**, not performance
* Fully functional services or storage are **not required**

---

## Evaluation Criteria

| Area               | What We're Looking For                                                        |
| ------------------ | ----------------------------------------------------------------------------- |
| **Clarity**        | Is the architecture well-structured and easy to follow?                       |
| **Extensibility**  | Can this design support more transaction types with minimal change?           |
| **Testability**    | Can this design be verified, mocked, and validated easily by a QA?            |
| **Team alignment** | Did devs and QAs define clear boundaries for their roles?                     |
| **Resilience**     | Does the design account for missing/unknown transactions or service failures? |

---

## Tech Stack Freedom

You may use **any language or framework**. If unsure, default to:

* Dev: TypeScript/JavaScript or Java
* QA: Postman collections, REST-assured, or Markdown test plan
