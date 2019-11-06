package fr.training.samples.spring.shop.domain.customer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * @author Badr NASS
 *
 */
@Embeddable
public class CustomerVO implements Serializable {

    /**
     * serialVersionUID of type long
     */
    private static final long serialVersionUID = 1L;

    /**
     * name of type String
     */
	@Column
    private String name;

    /**
     * password of type String
     */
	@Column
    private String password;

    /**
     * 
     */
    public CustomerVO() {
        super();
    }

    /**
     * @param name
     * @param password
     */
    public CustomerVO(@NotNull final String name, @NotNull final String password) {
        this.name = name;
        this.password = password;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomerVO other = (CustomerVO) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        return true;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (password == null ? 0 : password.hashCode());
        return result;
    }

    /**
     * @param name
     */
    public void setName(@NotNull final String name) {
        this.name = name;
    }

    /**
     * @param password
     */
    public void setPassword(@NotNull final String password) {
        this.password = password;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CustomerVO [name=" + name + ", password=" + password + "]";
    }

}
