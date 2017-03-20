/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpi135;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "caso_detalle_requisito", catalog = "casosacadtpi135", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalleRequisito.findAll", query = "SELECT c FROM CasoDetalleRequisito c")
    , @NamedQuery(name = "CasoDetalleRequisito.findByIdCasoDetalleRequisito", query = "SELECT c FROM CasoDetalleRequisito c WHERE c.casoDetalleRequisitoPK.idCasoDetalleRequisito = :idCasoDetalleRequisito")
    , @NamedQuery(name = "CasoDetalleRequisito.findByIdCasoDetalle", query = "SELECT c FROM CasoDetalleRequisito c WHERE c.casoDetalleRequisitoPK.idCasoDetalle = :idCasoDetalle")})
public class CasoDetalleRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CasoDetalleRequisitoPK casoDetalleRequisitoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCasoDetalleRequisito")
    private List<CasoDetalleRequisitoAtestado> casoDetalleRequisitoAtestadoList;
    @JoinColumn(name = "id_caso_detalle", referencedColumnName = "id_caso_detalle", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CasoDetalle casoDetalle;

    public CasoDetalleRequisito() {
    }

    public CasoDetalleRequisito(CasoDetalleRequisitoPK casoDetalleRequisitoPK) {
        this.casoDetalleRequisitoPK = casoDetalleRequisitoPK;
    }

    public CasoDetalleRequisito(int idCasoDetalleRequisito, int idCasoDetalle) {
        this.casoDetalleRequisitoPK = new CasoDetalleRequisitoPK(idCasoDetalleRequisito, idCasoDetalle);
    }

    public CasoDetalleRequisitoPK getCasoDetalleRequisitoPK() {
        return casoDetalleRequisitoPK;
    }

    public void setCasoDetalleRequisitoPK(CasoDetalleRequisitoPK casoDetalleRequisitoPK) {
        this.casoDetalleRequisitoPK = casoDetalleRequisitoPK;
    }

    @XmlTransient
    public List<CasoDetalleRequisitoAtestado> getCasoDetalleRequisitoAtestadoList() {
        return casoDetalleRequisitoAtestadoList;
    }

    public void setCasoDetalleRequisitoAtestadoList(List<CasoDetalleRequisitoAtestado> casoDetalleRequisitoAtestadoList) {
        this.casoDetalleRequisitoAtestadoList = casoDetalleRequisitoAtestadoList;
    }

    public CasoDetalle getCasoDetalle() {
        return casoDetalle;
    }

    public void setCasoDetalle(CasoDetalle casoDetalle) {
        this.casoDetalle = casoDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (casoDetalleRequisitoPK != null ? casoDetalleRequisitoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalleRequisito)) {
            return false;
        }
        CasoDetalleRequisito other = (CasoDetalleRequisito) object;
        if ((this.casoDetalleRequisitoPK == null && other.casoDetalleRequisitoPK != null) || (this.casoDetalleRequisitoPK != null && !this.casoDetalleRequisitoPK.equals(other.casoDetalleRequisitoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.CasoDetalleRequisito[ casoDetalleRequisitoPK=" + casoDetalleRequisitoPK + " ]";
    }
    
}
