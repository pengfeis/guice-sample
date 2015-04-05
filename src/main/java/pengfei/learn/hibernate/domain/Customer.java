package pengfei.learn.hibernate.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer_customers")
public class Customer {

    @Id
    @Column(name="CUSTOMER_ID")
    private Long customerId;

    @Column(name="CUSTOMER_NAME")
    private String customerName;

    @Column(name="DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Column(name="JOIN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinTime;

    @Column(name="CUSTOMER_TYPE")
    private String customerType;

    @Override
    public String toString() {
        return this.customerName + "_" + this.customerType + "_" + this.dob.toString();
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
