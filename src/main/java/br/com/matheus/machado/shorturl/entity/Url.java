package br.com.matheus.machado.shorturl.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "url")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Url.findAll", query = "SELECT u FROM Url u"),
    @NamedQuery(name = "Url.findById", query = "SELECT u FROM Url u WHERE u.id = :id"),
    @NamedQuery(name = "Url.findByAlias", query = "SELECT u FROM Url u WHERE u.alias = :alias")})
public class Url implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @NotEmpty(message = "Field alias is required")
    @Size(min = 1, max = 255)
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Lob
    @NotEmpty(message = "Field url is required")
    @Pattern(regexp = "(ftp|http|https):\\/\\/(\\w+:{0,1}\\w*@)?(\\S+)(:[0-9]+)?(\\/|\\/([\\w#!:.?+=&%@!\\-\\/]))?", message = "Invalid URL")
    @Size(min = 1, max = 65535)
    private String url;

    public Url() {
    }

    public Url(Long id) {
        this.id = id;
    }

    public Url(Long id, String alias, String url) {
        this.id = id;
        this.alias = alias;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Url)) {
            return false;
        }
        Url other = (Url) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.matheus.machado.shorturl.entity.Url[ id=" + id + " ]";
    }

}
