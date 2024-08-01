public class Contenedor extends Vehiculo {

    public boolean validarContenedor(String numeroContenedor) {
        numeroContenedor = numeroContenedor.replace("-", "");

        if (numeroContenedor.length() != 11) {
            return false;
        }

        String letras = numeroContenedor.substring(0, 4).toUpperCase();
        String numeros = numeroContenedor.substring(4, 10);

        int numeroVerificador = Integer.parseInt(numeroContenedor.substring(10, 11));

        java.util.Map<Character, Integer> valoresLetras = new java.util.HashMap<>();
        valoresLetras.put('A', 10); valoresLetras.put('B', 12); valoresLetras.put('C', 13); valoresLetras.put('D', 14);
        valoresLetras.put('E', 15); valoresLetras.put('F', 16); valoresLetras.put('G', 17); valoresLetras.put('H', 18);
        valoresLetras.put('I', 19); valoresLetras.put('J', 20); valoresLetras.put('K', 21); valoresLetras.put('L', 23);
        valoresLetras.put('M', 24); valoresLetras.put('N', 25); valoresLetras.put('O', 26); valoresLetras.put('P', 27);
        valoresLetras.put('Q', 28); valoresLetras.put('R', 29); valoresLetras.put('S', 30); valoresLetras.put('T', 31);
        valoresLetras.put('U', 32); valoresLetras.put('V', 34); valoresLetras.put('W', 35); valoresLetras.put('X', 36);
        valoresLetras.put('Y', 37); valoresLetras.put('Z', 38);

        for (int i = 0; i < 4; i++) {
            if (!valoresLetras.containsKey(letras.charAt(i))) {
                return false;
            }
        }

        int sum = 0;

        sum += valoresLetras.get(letras.charAt(0)) * 1;
        sum += valoresLetras.get(letras.charAt(1)) * 2;
        sum += valoresLetras.get(letras.charAt(2)) * 4;
        sum += valoresLetras.get(letras.charAt(3)) * 8;

        sum += Character.getNumericValue(numeros.charAt(0)) * 16;
        sum += Character.getNumericValue(numeros.charAt(1)) * 32;
        sum += Character.getNumericValue(numeros.charAt(2)) * 64;
        sum += Character.getNumericValue(numeros.charAt(3)) * 128;
        sum += Character.getNumericValue(numeros.charAt(4)) * 256;
        sum += Character.getNumericValue(numeros.charAt(5)) * 512;

        int numeroVerificadorCalculado = sum % 11;

        if (numeroVerificadorCalculado == 10) {
            numeroVerificadorCalculado = 0;
        }
        return numeroVerificadorCalculado == numeroVerificador;
    }

}
