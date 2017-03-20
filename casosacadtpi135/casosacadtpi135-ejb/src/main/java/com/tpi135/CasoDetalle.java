/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpi135;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "caso_detalle", catalog = "casosacadtpi135", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalle.findAll", query = "SELECT c FROM CasoDetalle c")
    , @NamedQuery(name = "CasoDetalle.findByIdCasoDetalle", query = "SELECT c FROM CasoDetalle c WHERE c.casoDetallePK.idCasoDetalle = :idCasoDetalle")
    , @NamedQuery(name = "CasoDetalle.findByIdCaso", query = "SELECT c FROM CasoDetalle c WHERE c.casoDetallePK.idCaso = :idCaso")
    , @NamedQuery(name = "CasoDetalle.findByEncargadocaso", query = "SELECT c FROM CasoDetalle c WHERE c.encargadocaso = :encargadocaso")
    , @NamedQuery(name = "CasoDetalle.findByEstadocaso", query = "SELECT c FROM CasoDetalle c WHERE c.estadocaso = :estadocaso")
    , @NamedQuery(name = "CasoDetalle.findByFechainiciocaso", query = "SELECT c FROM CasoDetalle c WHERE c.fechainiciocaso = :fechainiciocaso")})
public class CasoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CasoDetallePK casoDetallePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Encargado_caso", nullable = false, length = 10)
    private String encargadocaso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Estado_caso", nullable = false, length = 10)
    private String estadocaso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_inicio_caso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechainiciocaso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "casoDetalle")
    private List<CasoDetalleRequisito> casoDetalleRequisitoList;
    @JoinColumn(name = "id_caso", referencedColumnName = "id_caso", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Caso caso;

    public CasoDetalle() {
    }

    public CasoDetalle(CasoDetallePK casoDetallePK) {
        this.casoDetallePK = casoDetallePK;
    }

    public CasoDetalle(CasoDetallePK casoDetallePK, String encargadocaso, String estadocaso, Date fechainiciocaso) {
        this.casoDetallePK = casoDetallePK;
        this.encargadocaso = encargadocaso;
        this.estadocaso = estadocaso;
        this.fechainiciocaso = fechainiciocaso;
    }

    public CasoDetalle(int idCasoDetalle, int idCaso) {
        this.casoDetallePK = new CasoDetallePK(idCasoDetalle, idCaso);
    }

    public CasoDetallePK getCasoDetallePK() {
        return casoDetallePK;
    }

    public void setCasoDetallePK(CasoDetallePK casoDetallePK) {
        this.casoDetallePK = casoDetallePK;
    }

    public String getEncargadocaso() {
        return encargadocaso;
    }

    public void setEncargadocaso(String encargadocaso) {
        this.encargadocaso = encargadocaso;
    }

    public String getEstadocaso() {
        return estadocaso;
    }

    public void setEstadocaso(String estadocaso) {
        this.estadocaso = estadocaso;
    }

    public Date getFechainiciocaso() {
        return fechainiciocaso;
    }

    public void setFechainiciocaso(Date fechainiciocaso) {
        this.fechainiciocaso = fechainiciocaso;
    }

    @XmlTransient
    public List<CasoDetalleRequisito> getCasoDetalleRequisitoList() {
        return casoDetalleRequisitoList;
    }

    public void setCasoDetalleRequisitoList(List<CasoDetalleRequisito> casoDetalleRequisitoList) {
        this.casoDetalleRequisitoList = casoDetalleRequisitoList;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (casoDetallePK != null ? casoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalle)) {
            return false;
        }
        CasoDetalle other = (CasoDetalle) object;
        if ((this.casoDetallePK == null && other.casoDetallePK != null) || (this.casoDetallePK != null && !this.casoDetallePK.equals(other.casoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.CasoDetalle[ casoDetallePK=" + casoDetallePK + " ]";
    }
    
}
