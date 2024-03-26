import java.util.Random;
public class PasswordGenerator {
    public static final String LOWERCASE_CHARACTERS ="abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS ="0123456789";
    public static final String SPEACIAL_SYMBOLS ="!@#$%^&*()-_=+[]{};:,.<>/?"; 

    private final Random random;

    public PasswordGenerator(){random = new Random();}

    public String generatePassword(int length, boolean includeUppercase, boolean includeLowerCase, boolean includeNumbers,
            boolean includeSpecialSymbols){
            StringBuilder passwordBuilder = new StringBuilder();

            String  validCharacters = " ";
            if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
            if(includeLowerCase) validCharacters += LOWERCASE_CHARACTERS;
            if(includeNumbers)  validCharacters +=  NUMBERS;
            if(includeSpecialSymbols) validCharacters += SPEACIAL_SYMBOLS;

            //build password

            for (int i = 0; i < length; i++) {

                // generate a random index
                int randomIndex = random.nextInt(validCharacters.length());

                //get the char based on the random index
                char randomChar = validCharacters.charAt(randomIndex);

                //store char into password builder
                passwordBuilder.append(randomChar);

                // do this until we have reeached the length that the user has provided to us
            }

            // return the result
            return passwordBuilder.toString();

            }
}
