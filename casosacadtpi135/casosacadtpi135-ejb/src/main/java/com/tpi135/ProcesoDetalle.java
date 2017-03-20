/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpi135;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "proceso_detalle", catalog = "casosacadtpi135", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoDetalle.findAll", query = "SELECT p FROM ProcesoDetalle p")
    , @NamedQuery(name = "ProcesoDetalle.findByIdProceso", query = "SELECT p FROM ProcesoDetalle p WHERE p.procesoDetallePK.idProceso = :idProceso")
    , @NamedQuery(name = "ProcesoDetalle.findByIdPaso", query = "SELECT p FROM ProcesoDetalle p WHERE p.procesoDetallePK.idPaso = :idPaso")
    , @NamedQuery(name = "ProcesoDetalle.findByInicioProceso", query = "SELECT p FROM ProcesoDetalle p WHERE p.inicioProceso = :inicioProceso")
    , @NamedQuery(name = "ProcesoDetalle.findByFinalProceso", query = "SELECT p FROM ProcesoDetalle p WHERE p.finalProceso = :finalProceso")
    , @NamedQuery(name = "ProcesoDetalle.findByEstadoproceso", query = "SELECT p FROM ProcesoDetalle p WHERE p.estadoproceso = :estadoproceso")
    , @NamedQuery(name = "ProcesoDetalle.findByEncargadoproceso", query = "SELECT p FROM ProcesoDetalle p WHERE p.encargadoproceso = :encargadoproceso")})
public class ProcesoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesoDetallePK procesoDetallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio_proceso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date inicioProceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "final_proceso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date finalProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Estado_proceso", nullable = false, length = 10)
    private String estadoproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Encargado_proceso", nullable = false, length = 10)
    private String encargadoproceso;
    @JoinColumn(name = "id_paso", referencedColumnName = "id_paso", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paso paso;
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proceso proceso;

    public ProcesoDetalle() {
    }

    public ProcesoDetalle(ProcesoDetallePK procesoDetallePK) {
        this.procesoDetallePK = procesoDetallePK;
    }

    public ProcesoDetalle(ProcesoDetallePK procesoDetallePK, Date inicioProceso, Date finalProceso, String estadoproceso, String encargadoproceso) {
        this.procesoDetallePK = procesoDetallePK;
        this.inicioProceso = inicioProceso;
        this.finalProceso = finalProceso;
        this.estadoproceso = estadoproceso;
        this.encargadoproceso = encargadoproceso;
    }

    public ProcesoDetalle(int idProceso, int idPaso) {
        this.procesoDetallePK = new ProcesoDetallePK(idProceso, idPaso);
    }

    public ProcesoDetallePK getProcesoDetallePK() {
        return procesoDetallePK;
    }

    public void setProcesoDetallePK(ProcesoDetallePK procesoDetallePK) {
        this.procesoDetallePK = procesoDetallePK;
    }

    public Date getInicioProceso() {
        return inicioProceso;
    }

    public void setInicioProceso(Date inicioProceso) {
        this.inicioProceso = inicioProceso;
    }

    public Date getFinalProceso() {
        return finalProceso;
    }

    public void setFinalProceso(Date finalProceso) {
        this.finalProceso = finalProceso;
    }

    public String getEstadoproceso() {
        return estadoproceso;
    }

    public void setEstadoproceso(String estadoproceso) {
        this.estadoproceso = estadoproceso;
    }

    public String getEncargadoproceso() {
        return encargadoproceso;
    }

    public void setEncargadoproceso(String encargadoproceso) {
        this.encargadoproceso = encargadoproceso;
    }

    public Paso getPaso() {
        return paso;
    }

    public void setPaso(Paso paso) {
        this.paso = paso;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesoDetallePK != null ? procesoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoDetalle)) {
            return false;
        }
        ProcesoDetalle other = (ProcesoDetalle) object;
        if ((this.procesoDetallePK == null && other.procesoDetallePK != null) || (this.procesoDetallePK != null && !this.procesoDetallePK.equals(other.procesoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.ProcesoDetalle[ procesoDetallePK=" + procesoDetallePK + " ]";
    }
    
}
