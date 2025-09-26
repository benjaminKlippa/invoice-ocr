using System;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        string url = "https://dochorizon.klippa.com/api/services/document_capturing/v1/financial";
        string apiKey = "{your-api-key}";
        HttpClient client = new HttpClient();
        client.DefaultRequestHeaders.Add("x-api-key", apiKey);

        string body =
"{\"components\":{\"keyword_matching\":{\"rules\":[{\"id\":\"string\",\"keywords\":[\"string\"],\"regex\":\"string\"}]},\"relation_matching\":{\"assignments\":{\"customer\":{\"fallback_id\":\"string\",\"force_id\":\"string\",\"groups\":[\"string\"]},\"merchant\":{\"fallback_id\":\"string\",\"force_id\":\"string\",\"groups\":[\"string\"]}},\"relations\":[{\"bank_account_number\":\"string\",\"city\":\"string\",\"coc_number\":\"string\",\"country\":\"string\",\"email\":\"string\",\"groups\":[\"string\"],\"id\":\"string\",\"name\":\"string\",\"phone\":\"string\",\"preferred_currency\":\"string\",\"street_name\":\"string\",\"street_number\":\"string\",\"vat_number\":\"string\",\"website\":\"string\",\"zipcode\":\"string\"}]}},\"configuration\":{\"slug\":\"string\"},\"documents\":[{\"content_type\":\"string\",\"data\":\"string\",\"file_id\":\"string\",\"filename\":\"string\",\"page_ranges\":\"string\",\"password\":\"string\",\"url\":\"string\"}],\"preset\":{\"slug\":\"string\"},\"result_mapping\":[null]}";
        var content = new StringContent(body, Encoding.UTF8, "application/json");

        HttpResponseMessage response = await client.PostAsync(url, content);
        string responseBody = await response.Content.ReadAsStringAsync();

        Console.WriteLine("Response status code: " + response.StatusCode);
        Console.WriteLine("Response body: " + responseBody);
    }
}
