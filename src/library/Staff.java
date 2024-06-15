package library;

class Staff {
    protected String name;
    protected String staffId;

    public Staff(String name, String staffId) {
        this.name = name;
        this.staffId = staffId;
    }

    public void displayStaffInfo() {
        System.out.println("Staff Name: " + name);
        System.out.println("Staff ID: " + staffId);
    }
}
