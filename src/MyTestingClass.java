class MyTestingClass {
    private int value;

    public MyTestingClass(int value) {
        this.value = value;
    }
    @Override
    public int hashCode() {
        return value % 11;
    }
}