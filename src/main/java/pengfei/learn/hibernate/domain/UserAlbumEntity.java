package pengfei.learn.hibernate.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_album", schema = "", catalog = "dev")
public class UserAlbumEntity {
    private int id;
    private String title;
    private String image;
    private String albumType;
    private Timestamp uploadDate;
    private RxUserEntity rxUserEntity;

    @ManyToOne(cascade = CascadeType.ALL, optional=false)
    @JoinColumn(name = "rx_user_mobile_num")
    public RxUserEntity getRxUserEntity() {
        return rxUserEntity;
    }

    public void setRxUserEntity(RxUserEntity rxUserEntity) {
        this.rxUserEntity = rxUserEntity;
    }

    @Transient
    private Long userNameId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "image", nullable = false, insertable = true, updatable = true, length = 100)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "album_type", nullable = false, insertable = true, updatable = true, length = 10)
    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    @Basic
    @Column(name = "upload_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAlbumEntity that = (UserAlbumEntity) o;

        if (id != that.id) {
            return false;
        }
        if (title != null ? !title.equals(that.title) : that.title != null) {
            return false;
        }
        if (image != null ? !image.equals(that.image) : that.image != null) {
            return false;
        }

        if (!((albumType != null) ? !albumType.equals(that.albumType) : (that.albumType != null)) && !(uploadDate != null ? !uploadDate.equals(that.uploadDate) : that.uploadDate != null))
            return true;
        else return false;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (albumType != null ? albumType.hashCode() : 0);
        result = 31 * result + (uploadDate != null ? uploadDate.hashCode() : 0);
        return result;
    }
}
