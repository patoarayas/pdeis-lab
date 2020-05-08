// Custom package mapping
["java:package:cl.ucn.disc.pdis.lab.zeroice"]
module model
{
    // The API
    interface Engine
    {
        string getDate();
        /**
        * Calcula el dígito verificador de un rut y lo retorna.
        **/

        string getDigitoVerificador(string rut);
    }

}
