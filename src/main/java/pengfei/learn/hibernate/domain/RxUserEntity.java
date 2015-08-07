package pengfei.learn.hibernate.domain;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "rx_user", schema = "", catalog = "dev")
public class RxUserEntity {
    private String password;
    private Timestamp lastLogin;
    private String nickName;
    private String mobileNumber;
    private Timestamp registerDt;
    private Timestamp dateOfBirth;
    private Timestamp updateDt;
    private byte isAdmin;
    private char gender;
    private List<UserAlbumEntity> userAlbumEntities = Lists.newArrayList();

    @OneToMany(targetEntity = UserAlbumEntity.class, cascade = {CascadeType.ALL},  fetch=FetchType.EAGER, mappedBy = "rxUserEntity")
    public List<UserAlbumEntity> getUserAlbumEntities() {
        return userAlbumEntities;
    }

    public void setUserAlbumEntities(List<UserAlbumEntity> userAlbumEntities) {
        this.userAlbumEntities = userAlbumEntities;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "last_login", nullable = false, insertable = true, updatable = true)
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Basic
    @Column(name = "nick_name", nullable = true, insertable = true, updatable = true, length = 40)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    @Id
    @Column(name = "mobile_number", nullable = false, insertable = true, updatable = true, length = 20)
    public String getMobileNumber() {
        return mobileNumber;
    }




    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Basic
    @Column(name = "register_dt", nullable = false, insertable = true, updatable = true)
    public Timestamp getRegisterDt() {
        return registerDt;
    }

    public void setRegisterDt(Timestamp registerDt) {
        this.registerDt = registerDt;
    }

    @Basic
    @Column(name = "date_of_birth", nullable = false, insertable = true, updatable = true)
    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "update_dt", nullable = false, insertable = true, updatable = true)
    public Timestamp getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Timestamp updateDt) {
        this.updateDt = updateDt;
    }

    @Basic
    @Column(name = "is_admin", nullable = false, insertable = true, updatable = true)
    public byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Basic
    @Column(name = "gender", nullable = false, insertable = true, updatable = true, length = 1)
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        RxUserEntity that = (RxUserEntity) o;
//
//        if (isAdmin != that.isAdmin) return false;
//        if (password != null ? !password.equals(that.password) : that.password != null) return false;
//        if (lastLogin != null ? !lastLogin.equals(that.lastLogin) : that.lastLogin != null) return false;
//        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
//        if (mobileNumber != null ? !mobileNumber.equals(that.mobileNumber) : that.mobileNumber != null) return false;
//        if (registerDt != null ? !registerDt.equals(that.registerDt) : that.registerDt != null) return false;
//        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
//        if (updateDt != null ? !updateDt.equals(that.updateDt) : that.updateDt != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = 1;
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
//        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
//        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
//        result = 31 * result + (registerDt != null ? registerDt.hashCode() : 0);
//        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
//        result = 31 * result + (updateDt != null ? updateDt.hashCode() : 0);
//        result = 31 * result + (int) isAdmin;
//        result = 31 * result + (gender > 0 ? 0 : 0);
//        return result;
//    }

    @Override
    public String toString() {
        return this.getMobileNumber() + "@" + this.getGender();
    }


}
