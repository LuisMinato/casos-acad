/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpi135;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "caso", catalog = "casosacadtpi135", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caso.findAll", query = "SELECT c FROM Caso c")
    , @NamedQuery(name = "Caso.findByIdCaso", query = "SELECT c FROM Caso c WHERE c.casoPK.idCaso = :idCaso")
    , @NamedQuery(name = "Caso.findByIdSolicitud", query = "SELECT c FROM Caso c WHERE c.casoPK.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "Caso.findByNombrecaso", query = "SELECT c FROM Caso c WHERE c.nombrecaso = :nombrecaso")
    , @NamedQuery(name = "Caso.findByDescripcioncaso", query = "SELECT c FROM Caso c WHERE c.descripcioncaso = :descripcioncaso")})
public class Caso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CasoPK casoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Nombre_caso", nullable = false, length = 10)
    private String nombrecaso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Descripcion_caso", nullable = false, length = 10)
    private String descripcioncaso;
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Solicitud solicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caso")
    private List<Proceso> procesoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caso")
    private List<CasoDetalle> casoDetalleList;

    public Caso() {
    }

    public Caso(CasoPK casoPK) {
        this.casoPK = casoPK;
    }

    public Caso(CasoPK casoPK, String nombrecaso, String descripcioncaso) {
        this.casoPK = casoPK;
        this.nombrecaso = nombrecaso;
        this.descripcioncaso = descripcioncaso;
    }

    public Caso(int idCaso, int idSolicitud) {
        this.casoPK = new CasoPK(idCaso, idSolicitud);
    }

    public CasoPK getCasoPK() {
        return casoPK;
    }

    public void setCasoPK(CasoPK casoPK) {
        this.casoPK = casoPK;
    }

    public String getNombrecaso() {
        return nombrecaso;
    }

    public void setNombrecaso(String nombrecaso) {
        this.nombrecaso = nombrecaso;
    }

    public String getDescripcioncaso() {
        return descripcioncaso;
    }

    public void setDescripcioncaso(String descripcioncaso) {
        this.descripcioncaso = descripcioncaso;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    @XmlTransient
    public List<Proceso> getProcesoList() {
        return procesoList;
    }

    public void setProcesoList(List<Proceso> procesoList) {
        this.procesoList = procesoList;
    }

    @XmlTransient
    public List<CasoDetalle> getCasoDetalleList() {
        return casoDetalleList;
    }

    public void setCasoDetalleList(List<CasoDetalle> casoDetalleList) {
        this.casoDetalleList = casoDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (casoPK != null ? casoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caso)) {
            return false;
        }
        Caso other = (Caso) object;
        if ((this.casoPK == null && other.casoPK != null) || (this.casoPK != null && !this.casoPK.equals(other.casoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.Caso[ casoPK=" + casoPK + " ]";
    }
    
}
