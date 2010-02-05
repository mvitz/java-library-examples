package de.mvitz.examples.aspectj;

public class User {

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        return this.name == null ? other.name == null : this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = result + this.name == null ? 0 : this.name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.name == null ? "" : this.name;
    }

}
