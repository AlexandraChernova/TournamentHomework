
public class NotFoundException extends RuntimeException {
    public NotFoundException(String name) {
        super("Игрок не найден");
    }
}
