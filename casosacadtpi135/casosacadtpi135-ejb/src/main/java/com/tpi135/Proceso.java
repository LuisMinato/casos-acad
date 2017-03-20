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
@Table(name = "proceso", catalog = "casosacadtpi135", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p")
    , @NamedQuery(name = "Proceso.findByIdProceso", query = "SELECT p FROM Proceso p WHERE p.procesoPK.idProceso = :idProceso")
    , @NamedQuery(name = "Proceso.findByIdCaso", query = "SELECT p FROM Proceso p WHERE p.procesoPK.idCaso = :idCaso")
    , @NamedQuery(name = "Proceso.findByNombreproceso", query = "SELECT p FROM Proceso p WHERE p.nombreproceso = :nombreproceso")
    , @NamedQuery(name = "Proceso.findByDescripcionproceso", query = "SELECT p FROM Proceso p WHERE p.descripcionproceso = :descripcionproceso")})
public class Proceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesoPK procesoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Nombre_proceso", nullable = false, length = 10)
    private String nombreproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Descripcion_proceso", nullable = false, length = 10)
    private String descripcionproceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proceso")
    private List<ProcesoDetalle> procesoDetalleList;
    @JoinColumn(name = "id_caso", referencedColumnName = "id_caso", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Caso caso;

    public Proceso() {
    }

    public Proceso(ProcesoPK procesoPK) {
        this.procesoPK = procesoPK;
    }

    public Proceso(ProcesoPK procesoPK, String nombreproceso, String descripcionproceso) {
        this.procesoPK = procesoPK;
        this.nombreproceso = nombreproceso;
        this.descripcionproceso = descripcionproceso;
    }

    public Proceso(int idProceso, int idCaso) {
        this.procesoPK = new ProcesoPK(idProceso, idCaso);
    }

    public ProcesoPK getProcesoPK() {
        return procesoPK;
    }

    public void setProcesoPK(ProcesoPK procesoPK) {
        this.procesoPK = procesoPK;
    }

    public String getNombreproceso() {
        return nombreproceso;
    }

    public void setNombreproceso(String nombreproceso) {
        this.nombreproceso = nombreproceso;
    }

    public String getDescripcionproceso() {
        return descripcionproceso;
    }

    public void setDescripcionproceso(String descripcionproceso) {
        this.descripcionproceso = descripcionproceso;
    }

    @XmlTransient
    public List<ProcesoDetalle> getProcesoDetalleList() {
        return procesoDetalleList;
    }

    public void setProcesoDetalleList(List<ProcesoDetalle> procesoDetalleList) {
        this.procesoDetalleList = procesoDetalleList;
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
        hash += (procesoPK != null ? procesoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceso)) {
            return false;
        }
        Proceso other = (Proceso) object;
        if ((this.procesoPK == null && other.procesoPK != null) || (this.procesoPK != null && !this.procesoPK.equals(other.procesoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.Proceso[ procesoPK=" + procesoPK + " ]";
    }
    
}
