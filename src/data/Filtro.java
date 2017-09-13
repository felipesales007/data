package data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "filtro", catalog = "data", schema = "")
@NamedQueries({
    @NamedQuery(name = "Filtro.findAll", query = "SELECT f FROM Filtro f"),
    @NamedQuery(name = "Filtro.findById", query = "SELECT f FROM Filtro f WHERE f.id = :id"),
    @NamedQuery(name = "Filtro.findByNome", query = "SELECT f FROM Filtro f WHERE f.nome = :nome"),
    @NamedQuery(name = "Filtro.findByDataInicio", query = "SELECT f FROM Filtro f WHERE f.dataInicio = :dataInicio"),
    @NamedQuery(name = "Filtro.findByDataFim", query = "SELECT f FROM Filtro f WHERE f.dataFim = :dataFim")})
public class Filtro implements Serializable
{
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    public Filtro() 
    {
        
    }

    public Filtro(Integer id)
    {
        this.id = id;
    }

    public Filtro(Integer id, String nome, Date dataInicio) 
    {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
    }

    Filtro(String eduardo, String string, int i, int i0, int i1, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Filtro(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Filtro(ResultSet resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id)
    {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Date getDataInicio() 
    {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) 
    {
        Date oldDataInicio = this.dataInicio;
        this.dataInicio = dataInicio;
        changeSupport.firePropertyChange("dataInicio", oldDataInicio, dataInicio);
    }

    public Date getDataFim()
    {
        return dataFim;
    }

    public void setDataFim(Date dataFim) 
    {
        Date oldDataFim = this.dataFim;
        this.dataFim = dataFim;
        changeSupport.firePropertyChange("dataFim", oldDataFim, dataFim);
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        if (!(object instanceof Filtro)) 
        {
            return false;
        }
        Filtro other = (Filtro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return "data.Filtro[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) 
    {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) 
    {
        changeSupport.removePropertyChangeListener(listener);
    }  
}