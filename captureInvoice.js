
import fetch from 'node-fetch';
const url = 'https://dochorizon.klippa.com/api/services/document_capturing/v1/financial';
const apiKey = 'enter API key here';

const headers = {
    'x-api-key': apiKey,
    'Content-Type': 'application/json'
};

const body = JSON.stringify({
    "components": {
        "keyword_matching": {
            "rules": [
                {
                    "id": "",
                    "keywords": [
                        ""
                    ],
                    "regex": ""
                }
            ]
        },
        "relation_matching": {
            "assignments": {
                "customer": {
                    "fallback_id": "",
                    "force_id": "",
                    "groups": [
                        ""
                    ]
                },
                "merchant": {
                    "fallback_id": "",
                    "force_id": "",
                    "groups": [
                        ""
                    ]
                }
            },
            "relations": [
                {
                    "bank_account_number": "",
                    "city": "",
                    "coc_number": "",
                    "country": "",
                    "email": "",
                    "groups": [
                        ""
                    ],
                    "id": "",
                    "name": "",
                    "phone": "",
                    "preferred_currency": "",
                    "street_name": "",
                    "street_number": "",
                    "vat_number": "",
                    "website": "",
                    "zipcode": ""
                }
            ]
        }
    },
    "configuration": {
        "slug": "enter slug here"
    },
    "documents": [
        {
            "content_type": "",
            "data": "",
            "file_id": "",
            "filename": "",
            "page_ranges": "",
            "password": "",
            "url": ""
        }
    ],
    "preset": {
        "slug": "enter slug here"
    },
});

const response = await fetch(url, { method: 'POST', headers, body });
const result = await response.json();
console.dir(result, { depth: null });