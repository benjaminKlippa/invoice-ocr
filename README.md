# Invoice OCR for Invoice Processing & Information Extraction
This repository can be used to integrate Invoice OCR software to extract invoice information.
This invoice parser uses the DocHorizon OCR API to do invoice data extraction.

### How Klippa Invoice OCR Works:

- Image Upload: You first need to upload the image of the invoice you want to process.
- Data Extraction: Klippa uses machine learning models and image processing techniques to analyze the image, identify key data points, and extract relevant information.
- Data Formatting: The extracted data is then formatted into a structured format (like JSON), which can easily be consumed by applications or compared with other datasets.
- Response: The service returns the structured data to your application, allowing you to process it as needed.

## Things you need
- A DocHorizon API key and/or license
- An invoice file
- A Python 3.6+ environment
- [_link to swagger docs_](https://dochorizon.klippa.com/api/swagger#/)

## How to Connect to Klippa Invoice OCR with Python
To use the Klippa Invoice OCR API in your Python script, you can follow these steps:

**Step 1: Set Up Your Environment** <br/>
You need to make sure you have Python installed on your system. You should also install the request library if it’s not already installed.
Also look for the requirements.txt file to see which things you need to install.

**Step 2: Obtain Credentials** <br/>
Sign up for Klippa’s services and get your API key. This key will be required to authenticate your requests.
>See how to get your API key in the section below; [here](#license--api-key)

**Step 3: Run Python Script** <br/>
In the repo is a sample Python script that demonstrates how to upload a file to Klippa and fetch the OCR results.


### Explanation:
- API_URL: Change this to the actual endpoint you need to use. Check [Klippa’s documentation](https://dochorizon.klippa.com/api/swagger#/) for the correct API URLs.
- API_KEY: Place your Klippa API key here.
- image_path: Change this path to the actual path of the image you want to upload.
- request.components: You can enable of disable the different components in the request.
- At the end of the code, there is an example usage piece that can be used to test the code.

### Important Notes:
Ensure you use secure methods to store and manage your API keys.
Always refer to the official Klippa API documentation for the most up-to-date information, including any changes in endpoints or request formats.
The API may have rate limits or require specific image formats—consult the documentation for these details.

>Please ensure that the image is the only object in the image with edges clearly visible.

<img src="/images/example_invoice.jpg" alt="invoice-example">

### Example
An example of a POST request using cURL:

Also, the following endpoint is used from the [swagger](https://dochorizon.klippa.com/api/swagger#/Financial%20Document%20Capturing%20API/document-capturing-financial) docs.

<details>
<summary>Click here to see the full cURL command</summary>

```
curl -X POST \\
  -H "x-api-key: {your-api-key}" \\
  -H "Content-Type: application/json" \\
  -d '{
  "components": {
    "keyword_matching": {
      "rules": [
        {
          "id": "string",
          "keywords": [
            "string"
          ],
          "regex": "string"
        }
      ]
    },
    "relation_matching": {
      "assignments": {
        "customer": {
          "fallback_id": "string",
          "force_id": "string",
          "groups": [
            "string"
          ]
        },
        "merchant": {
          "fallback_id": "string",
          "force_id": "string",
          "groups": [
            "string"
          ]
        }
      },
      "relations": [
        {
          "bank_account_number": "string",
          "city": "string",
          "coc_number": "string",
          "country": "string",
          "email": "string",
          "groups": [
            "string"
          ],
          "id": "string",
          "name": "string",
          "phone": "string",
          "preferred_currency": "string",
          "street_name": "string",
          "street_number": "string",
          "vat_number": "string",
          "website": "string",
          "zipcode": "string"
        }
      ]
    }
  },
  "configuration": {
    "slug": "string"
  },
  "documents": [
    {
      "content_type": "string",
      "data": "string",
      "file_id": "string",
      "filename": "string",
      "page_ranges": "string",
      "password": "string",
      "url": "string"
    }
  ],
  "preset": {
    "slug": "string"
  },
  "result_mapping": [
    null
  ]
}' \\
  https://dochorizon.klippa.com/api/services/document_capturing/v1/financial
```

</details>

<details>
<summary>The expected JSON schema with a 200 OK response, when having all components enabled</summary>

```
{
  "components": {
    "amount_details": {
      "amount_change": 0,
      "amount_shipping": 0,
      "amount_tip": 0,
      "discounts": [
        {
          "amount": 0,
          "date": "string",
          "percentage": 0,
          "type": "string"
        }
      ],
      "payment_description": "string",
      "payments": [
        {
          "amount": 0,
          "method": "string"
        }
      ]
    },
    "barcode": {
      "barcodes": [
        {
          "type": "string",
          "value": "string"
        }
      ]
    },
    "chain_liability": {
      "amount": 0,
      "bank_account_number": "string"
    },
    "data_matching": {
      "matched_data_sources": [
        {
          "matched_collections": [
            {
              "collection_identifier": "string",
              "comparison_results": [
                {
                  "passed": false,
                  "rule": 0,
                  "score": 0,
                  "weight": 0
                }
              ],
              "matched_line_rate": 0,
              "remaining_lines_collection": [
                "string"
              ],
              "remaining_lines_document": [
                "integer"
              ]
            }
          ],
          "name": "string"
        }
      ]
    },
    "date_details": {
      "date_of_service_end": "string",
      "date_of_service_start": "string",
      "payment_due_date": "string"
    },
    "document_classification": {
      "value": [
        {
          "classification": "string",
          "type": "string"
        }
      ]
    },
    "document_country_code": {
      "value": "string"
    },
    "document_language": {
      "value": "string"
    },
    "financial": {
      "currency": "string",
      "customer": {
        "company_name": "string",
        "components": {
          "relation_address": {
            "addresses": [
              {
                "city": "string",
                "context": "string",
                "country": "string",
                "country_code": "string",
                "house_number": "string",
                "municipality": "string",
                "post_box": "string",
                "postal_code": "string",
                "province": "string",
                "raw_address": "string",
                "state": "string",
                "street_name": "string"
              }
            ]
          },
          "relation_details": {
            "activity_code": "string",
            "bank": {
              "account_number": "string",
              "account_number_bic": "string",
              "country_code": "string",
              "domestic_account_number": "string",
              "domestic_bank_code": "string",
              "domestic_branch_code": "string",
              "generated": [
                "string"
              ],
              "verification": {
                "checksum": false,
                "country": false,
                "length": false,
                "structure": false
              }
            },
            "coc_number": {
              "country_code": "string",
              "value": "string",
              "verifications": {
                "is_valid": false
              }
            },
            "email": "string",
            "eori_number": "string",
            "fiscal_number": "string",
            "phone": "string",
            "vat_number": {
              "country_code": "string",
              "standardized_value": "string",
              "value": "string",
              "verifications": {
                "is_valid": false
              }
            },
            "website": "string"
          },
          "relation_matching": {
            "match": {
              "id": "string"
            }
          }
        },
        "person": "string"
      },
      "document_date": "string",
      "invoice_number": "string",
      "merchant": {
        "brand_name": "string",
        "company_name": "string",
        "components": {
          "relation_address": {
            "addresses": [
              {
                "city": "string",
                "context": "string",
                "country": "string",
                "country_code": "string",
                "house_number": "string",
                "municipality": "string",
                "post_box": "string",
                "postal_code": "string",
                "province": "string",
                "raw_address": "string",
                "state": "string",
                "street_name": "string"
              }
            ]
          },
          "relation_details": {
            "activity_code": "string",
            "bank": {
              "account_number": "string",
              "account_number_bic": "string",
              "country_code": "string",
              "domestic_account_number": "string",
              "domestic_bank_code": "string",
              "domestic_branch_code": "string",
              "generated": [
                "string"
              ],
              "verification": {
                "checksum": false,
                "country": false,
                "length": false,
                "structure": false
              }
            },
            "coc_number": {
              "country_code": "string",
              "value": "string",
              "verifications": {
                "is_valid": false
              }
            },
            "email": "string",
            "eori_number": "string",
            "fiscal_number": "string",
            "phone": "string",
            "vat_number": {
              "country_code": "string",
              "standardized_value": "string",
              "value": "string",
              "verifications": {
                "is_valid": false
              }
            },
            "website": "string"
          },
          "relation_matching": {
            "match": {
              "id": "string"
            }
          }
        }
      },
      "tax_details": {
        "items": [
          {
            "amount": 0,
            "amount_excl_vat": 0,
            "amount_incl_vat": 0,
            "code": "string",
            "percentage": 0,
            "type": "string"
          }
        ]
      },
      "total_amount": 0
    },
    "hash": {
      "is_duplicate": false,
      "value": "string"
    },
    "healthcare_details": {
      "care_cluster_type": "string",
      "care_process": {
        "id": "string",
        "start_date": "string"
      },
      "diagnosis_code": "string",
      "medical_practice": {
        "address": {
          "city": "string",
          "context": "string",
          "country": "string",
          "country_code": "string",
          "house_number": "string",
          "municipality": "string",
          "post_box": "string",
          "postal_code": "string",
          "province": "string",
          "raw_address": "string",
          "state": "string",
          "street_name": "string"
        },
        "bank_details": {
          "account_number": "string",
          "account_number_bic": "string",
          "country_code": "string",
          "domestic_account_number": "string",
          "domestic_bank_code": "string",
          "domestic_branch_code": "string",
          "generated": [
            "string"
          ],
          "verification": {
            "checksum": false,
            "country": false,
            "length": false,
            "structure": false
          }
        },
        "license_number": "string",
        "name": "string"
      },
      "patient": {
        "address": {
          "city": "string",
          "context": "string",
          "country": "string",
          "country_code": "string",
          "house_number": "string",
          "municipality": "string",
          "post_box": "string",
          "postal_code": "string",
          "province": "string",
          "raw_address": "string",
          "state": "string",
          "street_name": "string"
        },
        "date_of_birth": "string",
        "insurance_policy_number": "string",
        "name": "string",
        "personal_number": "string"
      },
      "practitioners": [
        {
          "license_number": "string",
          "name": "string",
          "type": "string"
        }
      ],
      "privacy_policy": "string",
      "referral": {
        "license_number": "string",
        "type": "string"
      }
    },
    "keyword_matching": {
      "matches": [
        {
          "id": "string",
          "keyword": "string",
          "value": "string"
        }
      ]
    },
    "line_items": {
      "line_item_sections": [
        {
          "items": [
            {
              "amount": 0,
              "amount_each": 0,
              "amount_each_ex_vat": 0,
              "amount_ex_vat": 0,
              "amount_sub_total": 0,
              "commission": 0,
              "components": {
                "healthcare_details": {
                  "care_service_code": "string",
                  "care_service_reference_number": "string",
                  "practitioner": {
                    "license_number": "string",
                    "name": "string"
                  },
                  "profession_code": "string"
                },
                "line_item_matching": {
                  "matches": [
                    {
                      "id": "string"
                    }
                  ]
                },
                "matched_data_sources": [
                  {
                    "collection_identifier": "string",
                    "comparison_results": [
                      {
                        "passed": false,
                        "rule": 0,
                        "score": 0,
                        "weight": 0
                      }
                    ],
                    "data_source_name": "string",
                    "line_identifier": "string"
                  }
                ]
              },
              "country_of_origin": "string",
              "credit": false,
              "currency": "string",
              "date": "string",
              "description": "string",
              "discount_amount": 0,
              "discount_code": "string",
              "discount_percentage": 0,
              "ean": "string",
              "end_date": "string",
              "gross_weight": 0,
              "hs_code": "string",
              "line_number": "string",
              "matched_purchase_order": {
                "matched_amount": false,
                "matched_amount_each": false,
                "matched_quantity": false,
                "matched_sku": false,
                "matched_title": false,
                "matched_title_confidence": 0,
                "purchase_order_identifier": "string",
                "purchase_order_line_item_identifier": "string"
              },
              "net_weight": 0,
              "order_number": "string",
              "period": "string",
              "product_type": "string",
              "quantity": 0,
              "sku": "string",
              "time": "string",
              "title": "string",
              "unit_of_measurement": "string",
              "vat_amount": 0,
              "vat_code": "string",
              "vat_percentage": 0
            }
          ]
        }
      ]
    },
    "ocr": {
      "documents": [
        {
          "document_index": 0,
          "metadata": {
            "line_count": 0,
            "page_count": 0,
            "word_count": 0
          },
          "pages": [
            {
              "height": 0,
              "lines": [
                {
                  "text": "string",
                  "words": [
                    {
                      "text": "string"
                    }
                  ]
                }
              ],
              "metadata": {
                "line_count": 0,
                "word_count": 0
              },
              "page_index": 0,
              "text": "string",
              "width": 0
            }
          ]
        }
      ],
      "metadata": {
        "line_count": 0,
        "page_count": 0,
        "word_count": 0
      }
    },
    "payment_details": {
      "auth_code": "string",
      "card_account_number": "string",
      "card_issuer": "string",
      "card_number": "string",
      "payment_reference": "string",
      "payment_slip": {
        "code": "string",
        "customer_number": "string",
        "reference_number": "string"
      },
      "terminal_number": "string"
    },
    "project_code": {
      "value": "string"
    },
    "reference_details": {
      "credit_note_number": "string",
      "customer_number": "string",
      "order_number": "string",
      "purchase_order_number": "string",
      "shop_number": "string",
      "transaction_number": "string"
    },
    "transport_details": {
      "package_number": "string",
      "total_gross_weight": 0,
      "total_net_weight": 0
    },
    "travel_details": {
      "distance_traveled": {
        "unit": "string",
        "value": 0
      }
    }
  },
  "data_source": "string",
  "version": "string"
}
```

</details>

## License & API KEY
For this project and usage of the OCR technique, you would need to create an account and retrieve an API key.
Follow these steps to get your API key:
* Sign up via the [signup page](https://dochorizon.klippa.com/public/signup)
* Finish setting up the organization and create a first project
* Go to the project settings > Credentials page (1 & 2)
* Click on an existing credential or create a new one
* Make sure the right service is toggled on in the 'Access' tab (3 & 4)
* Go to the 'API Keys' tab and copy the API key
    * _Optional:_ Here you can also create a new API key if you want to have new keys for different use cases
* [Link to documentation](https://dochorizon.klippa.com/docs/platform/credentials) for further information

> Image of the Access page within an existing credential
<img src="/images/access_credentials_invoiceOCR.png" alt="screenshot API key" width="1000" height="400">

> In the API keys tab you will find the API key

## Background & support
We at Klippa have 10 years of experience in OCR and have built a robust and scalable solution for many customers.
Invoice OCR is one of the most popular services. Since invoice data extraction is a complex task, we have developed a robust and scalable solution that can be used by anyone.
Thanks to the engine we use and invoice parser, you can extract data from invoices.
To learn more about the Invoice OCR software we use, visit this [page.](https://www.klippa.com/en/ocr/financial-documents/invoices/)

If you have any questions or need support, please [contact](mailto:dochorizon-support@klippa.com) us.
Or visit the general [website.](https://klippa.com/)

## Other supported languages
This repository contains a sample Python script that demonstrates how to upload an image to Klippa and fetch the OCR results.
But upon request we can also provide other languages. For example:
- cUrl
- NodeJS
- PHP
- GO
- C#/.NET
- Java