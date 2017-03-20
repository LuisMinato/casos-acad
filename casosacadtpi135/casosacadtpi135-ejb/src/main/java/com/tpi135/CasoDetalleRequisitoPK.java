/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpi135;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juank
 */
@Embeddable
public class CasoDetalleRequisitoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_caso_detalle_requisito", nullable = false)
    private int idCasoDetalleRequisito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_caso_detalle", nullable = false)
    private int idCasoDetalle;

    public CasoDetalleRequisitoPK() {
    }

    public CasoDetalleRequisitoPK(int idCasoDetalleRequisito, int idCasoDetalle) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
        this.idCasoDetalle = idCasoDetalle;
    }

    public int getIdCasoDetalleRequisito() {
        return idCasoDetalleRequisito;
    }

    public void setIdCasoDetalleRequisito(int idCasoDetalleRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
    }

    public int getIdCasoDetalle() {
        return idCasoDetalle;
    }

    public void setIdCasoDetalle(int idCasoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCasoDetalleRequisito;
        hash += (int) idCasoDetalle;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalleRequisitoPK)) {
            return false;
        }
        CasoDetalleRequisitoPK other = (CasoDetalleRequisitoPK) object;
        if (this.idCasoDetalleRequisito != other.idCasoDetalleRequisito) {
            return false;
        }
        if (this.idCasoDetalle != other.idCasoDetalle) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.CasoDetalleRequisitoPK[ idCasoDetalleRequisito=" + idCasoDetalleRequisito + ", idCasoDetalle=" + idCasoDetalle + " ]";
    }
    
}
