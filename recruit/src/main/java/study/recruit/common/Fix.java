package study.recruit.common;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface Fix {


    String DEF_CURRENCY = "USD";
    double DEF_TAX_RATE = 0.1D;
    String URL = "http://localhost:8080/";
    Path IMG_DIR_PATH = Paths.get("src/main/resources/static/img/").toAbsolutePath().normalize();


    String PAYPAL_CLIENT_ID = "Ae-WAkmVpZzdf5yYCDsw712GLWeT1RMqWTwirxkRRFnEEvMWKKxvpcn6WW7k2tv6Ck7RmRDEPLLUdJ0F";
    String PAYPAL_CLIENT_SECRET = "EAbfxREiU06k1rVeIbql1kC0zNc0_-3Yw6JY0hpMCMjT3VLd4PQj_eJuvop4xINX6OJProI3f6F3B2Nn";
    String PAYPAL_MODE = "sandbox";

    /* API mapping */
    String MAP_ANY = "/any";
    String MAP_LOG = "/log";
    String MAP_ADM = "/adm";
    String MAP_CAN = "/can";
    String MAP_DEP = "/dep";
    String MAP_API = "/api";

    /* Role */
    String ROL_ADM = "ADMIN";
    String ROL_CAN = "CANDIDATE";
    String ROL_DEP = "DEPARTMENT";


}
