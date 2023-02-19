package apiTasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RatesAPI {

    public static void main(String[] args) throws JsonProcessingException {

        Response response = given()
                .when()
                .get("https://api.coingecko.com/api/v3/exchange_rates")
                .then()
                .extract()
                .response();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.readTree(response.getBody().asString());
        JsonNode ratesNode = node.get("rates");

        System.out.println("Number of crypto coins: " + ratesNode.size());
        System.out.println("=========================================");

        ratesNode.forEach(cryptoCurrency-> {
            System.out.println("Name: " + cryptoCurrency.get("name"));
            System.out.println("Value: " + cryptoCurrency.get("value"));
            System.out.println("=========================================");
        });
    }
}

/*
    {
  "rates": {
    "btc": {
      "name": "Bitcoin",
      "unit": "BTC",
      "value": 1,
      "type": "crypto"
    },
    "eth": {
      "name": "Ether",
      "unit": "ETH",
      "value": 14.553,
      "type": "crypto"
    },
    "ltc": {
      "name": "Litecoin",
      "unit": "LTC",
      "value": 247.79,
      "type": "crypto"
    },
    "bch": {
      "name": "Bitcoin Cash",
      "unit": "BCH",
      "value": 180.654,
      "type": "crypto"
    },
    "bnb": {
      "name": "Binance Coin",
      "unit": "BNB",
      "value": 78.303,
      "type": "crypto"
    },
    "eos": {
      "name": "EOS",
      "unit": "EOS",
      "value": 19866.373,
      "type": "crypto"
    },
    "xrp": {
      "name": "XRP",
      "unit": "XRP",
      "value": 62665.595,
      "type": "crypto"
    },
    "xlm": {
      "name": "Lumens",
      "unit": "XLM",
      "value": 268327.362,
      "type": "crypto"
    },
    "link": {
      "name": "Chainlink",
      "unit": "LINK",
      "value": 3048.332,
      "type": "crypto"
    },
    "dot": {
      "name": "Polkadot",
      "unit": "DOT",
      "value": 3430.668,
      "type": "crypto"
    },
    "yfi": {
      "name": "Yearn.finance",
      "unit": "YFI",
      "value": 3.325,
      "type": "crypto"
    },
    "usd": {
      "name": "US Dollar",
      "unit": "$",
      "value": 24711.871,
      "type": "fiat"
    },
    "aed": {
      "name": "United Arab Emirates Dirham",
      "unit": "DH",
      "value": 90765.467,
      "type": "fiat"
    },
    "ars": {
      "name": "Argentine Peso",
      "unit": "$",
      "value": 4760091.687,
      "type": "fiat"
    },
    "aud": {
      "name": "Australian Dollar",
      "unit": "A$",
      "value": 35923.647,
      "type": "fiat"
    },
    "bdt": {
      "name": "Bangladeshi Taka",
      "unit": "৳",
      "value": 2591154.058,
      "type": "fiat"
    },
    "bhd": {
      "name": "Bahraini Dinar",
      "unit": "BD",
      "value": 9291.021,
      "type": "fiat"
    },
    "bmd": {
      "name": "Bermudian Dollar",
      "unit": "$",
      "value": 24711.871,
      "type": "fiat"
    },
    "brl": {
      "name": "Brazil Real",
      "unit": "R$",
      "value": 127671.411,
      "type": "fiat"
    },
    "cad": {
      "name": "Canadian Dollar",
      "unit": "CA$",
      "value": 33298.01,
      "type": "fiat"
    },
    "chf": {
      "name": "Swiss Franc",
      "unit": "Fr.",
      "value": 22857.047,
      "type": "fiat"
    },
    "clp": {
      "name": "Chilean Peso",
      "unit": "CLP$",
      "value": 19506315.506,
      "type": "fiat"
    },
    "cny": {
      "name": "Chinese Yuan",
      "unit": "¥",
      "value": 169711.246,
      "type": "fiat"
    },
    "czk": {
      "name": "Czech Koruna",
      "unit": "Kč",
      "value": 547602.709,
      "type": "fiat"
    },
    "dkk": {
      "name": "Danish Krone",
      "unit": "kr.",
      "value": 172048.989,
      "type": "fiat"
    },
    "eur": {
      "name": "Euro",
      "unit": "€",
      "value": 23059.66,
      "type": "fiat"
    },
    "gbp": {
      "name": "British Pound Sterling",
      "unit": "£",
      "value": 20517.994,
      "type": "fiat"
    },
    "hkd": {
      "name": "Hong Kong Dollar",
      "unit": "HK$",
      "value": 193893.047,
      "type": "fiat"
    },
    "huf": {
      "name": "Hungarian Forint",
      "unit": "Ft",
      "value": 8866619.375,
      "type": "fiat"
    },
    "idr": {
      "name": "Indonesian Rupiah",
      "unit": "Rp",
      "value": 374763061.625,
      "type": "fiat"
    },
    "ils": {
      "name": "Israeli New Shekel",
      "unit": "₪",
      "value": 87761.739,
      "type": "fiat"
    },
    "inr": {
      "name": "Indian Rupee",
      "unit": "₹",
      "value": 2046492.605,
      "type": "fiat"
    },
    "jpy": {
      "name": "Japanese Yen",
      "unit": "¥",
      "value": 3313984.828,
      "type": "fiat"
    },
    "krw": {
      "name": "South Korean Won",
      "unit": "₩",
      "value": 32022631.134,
      "type": "fiat"
    },
    "kwd": {
      "name": "Kuwaiti Dinar",
      "unit": "KD",
      "value": 7570.975,
      "type": "fiat"
    },
    "lkr": {
      "name": "Sri Lankan Rupee",
      "unit": "Rs",
      "value": 9034828.905,
      "type": "fiat"
    },
    "mmk": {
      "name": "Burmese Kyat",
      "unit": "K",
      "value": 51910231.883,
      "type": "fiat"
    },
    "mxn": {
      "name": "Mexican Peso",
      "unit": "MX$",
      "value": 453739.608,
      "type": "fiat"
    },
    "myr": {
      "name": "Malaysian Ringgit",
      "unit": "RM",
      "value": 109523.013,
      "type": "fiat"
    },
    "ngn": {
      "name": "Nigerian Naira",
      "unit": "₦",
      "value": 11380805.147,
      "type": "fiat"
    },
    "nok": {
      "name": "Norwegian Krone",
      "unit": "kr",
      "value": 254151.71,
      "type": "fiat"
    },
    "nzd": {
      "name": "New Zealand Dollar",
      "unit": "NZ$",
      "value": 39570.649,
      "type": "fiat"
    },
    "php": {
      "name": "Philippine Peso",
      "unit": "₱",
      "value": 1367184.371,
      "type": "fiat"
    },
    "pkr": {
      "name": "Pakistani Rupee",
      "unit": "₨",
      "value": 6498604.32,
      "type": "fiat"
    },
    "pln": {
      "name": "Polish Zloty",
      "unit": "zł",
      "value": 109951.763,
      "type": "fiat"
    },
    "rub": {
      "name": "Russian Ruble",
      "unit": "₽",
      "value": 1829154.046,
      "type": "fiat"
    },
    "sar": {
      "name": "Saudi Riyal",
      "unit": "SR",
      "value": 92612.778,
      "type": "fiat"
    },
    "sek": {
      "name": "Swedish Krona",
      "unit": "kr",
      "value": 258268.707,
      "type": "fiat"
    },
    "sgd": {
      "name": "Singapore Dollar",
      "unit": "S$",
      "value": 33039.771,
      "type": "fiat"
    },
    "thb": {
      "name": "Thai Baht",
      "unit": "฿",
      "value": 849157.274,
      "type": "fiat"
    },
    "try": {
      "name": "Turkish Lira",
      "unit": "₺",
      "value": 465297.351,
      "type": "fiat"
    },
    "twd": {
      "name": "New Taiwan Dollar",
      "unit": "NT$",
      "value": 750964.11,
      "type": "fiat"
    },
    "uah": {
      "name": "Ukrainian hryvnia",
      "unit": "₴",
      "value": 908314.701,
      "type": "fiat"
    },
    "vef": {
      "name": "Venezuelan bolívar fuerte",
      "unit": "Bs.F",
      "value": 2474.399,
      "type": "fiat"
    },
    "vnd": {
      "name": "Vietnamese đồng",
      "unit": "₫",
      "value": 587119903.705,
      "type": "fiat"
    },
    "zar": {
      "name": "South African Rand",
      "unit": "R",
      "value": 446097.215,
      "type": "fiat"
    },
    "xdr": {
      "name": "IMF Special Drawing Rights",
      "unit": "XDR",
      "value": 18492.14,
      "type": "fiat"
    },
    "xag": {
      "name": "Silver - Troy Ounce",
      "unit": "XAG",
      "value": 1137.46,
      "type": "commodity"
    },
    "xau": {
      "name": "Gold - Troy Ounce",
      "unit": "XAU",
      "value": 13.411,
      "type": "commodity"
    },
    "bits": {
      "name": "Bits",
      "unit": "μBTC",
      "value": 1000000,
      "type": "crypto"
    },
    "sats": {
      "name": "Satoshi",
      "unit": "sats",
      "value": 100000000,
      "type": "crypto"
    }
  }
}

 */
