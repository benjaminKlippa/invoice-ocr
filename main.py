import base64
import requests

# Replace with your actual Klippa API endpoint and API key
API_URL = 'https://dochorizon.klippa.com/api/services/document_capturing/v1/financial'
API_KEY = 'insert API key here'


def upload_receipt(image_path: str):
    headers = {
        "Content-Type": "application/json",
        "x-api-key": API_KEY
    }

    with open(image_path, "rb") as handle:
        base64_file = base64.b64encode(handle.read()).decode("utf-8")

    request = {
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
            "slug": "insert configuration slug here"
        },
        "documents": [
            {
                # "content_type": "",
                "data": base64_file,
                # "file_id": "",
                # "filename": "",
                # "page_ranges": "",
                # "password": "",
                # "url": ""
            }
        ],
        "preset": {
            "slug": "insert preset slug here"
        },
        "result_mapping": [
            None
        ]
    }

    response = requests.post(
        url=API_URL,
        headers=headers,
        json=request,
        timeout=60
    )

    if response.status_code == 200:
        result = response.json()
        return result
    else:
        print(f"Error: {response.status_code}, {response.text}")
        return None


# Example usage
if __name__ == '__main__':
    image_path = 'insert file path here'
    result = upload_receipt(image_path)
    if result:
        print("Extracted Data:", result)