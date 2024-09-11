public class DeadCharacterException extends Exception {
    private Character character;

    public DeadCharacterException(Character fighter) {
        this.character = fighter;
    }

    public String getMessage() {
        String classType = this.character.getClass().toString();
        String result = "";
        switch (classType) {
            case "class Monster":
                result = "monster " + this.character.getName();
                break;
            case "class Sorcerer":
            result = "sorcerer " + this.character.getName();
                break;
            case "class Templar":
            result = "templar " + this.character.getName();
                break;
            default:
                break;
        }
        return "The " + result + " is dead.";//+ <sorcerer | monster | templar> <character.name> + " is dead."
    }
}