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
public class CasoDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_caso_detalle", nullable = false)
    private int idCasoDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_caso", nullable = false)
    private int idCaso;

    public CasoDetallePK() {
    }

    public CasoDetallePK(int idCasoDetalle, int idCaso) {
        this.idCasoDetalle = idCasoDetalle;
        this.idCaso = idCaso;
    }

    public int getIdCasoDetalle() {
        return idCasoDetalle;
    }

    public void setIdCasoDetalle(int idCasoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
    }

    public int getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(int idCaso) {
        this.idCaso = idCaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCasoDetalle;
        hash += (int) idCaso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetallePK)) {
            return false;
        }
        CasoDetallePK other = (CasoDetallePK) object;
        if (this.idCasoDetalle != other.idCasoDetalle) {
            return false;
        }
        if (this.idCaso != other.idCaso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.CasoDetallePK[ idCasoDetalle=" + idCasoDetalle + ", idCaso=" + idCaso + " ]";
    }
    
}
