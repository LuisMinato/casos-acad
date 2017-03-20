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
public class ProcesoDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proceso", nullable = false)
    private int idProceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_paso", nullable = false)
    private int idPaso;

    public ProcesoDetallePK() {
    }

    public ProcesoDetallePK(int idProceso, int idPaso) {
        this.idProceso = idProceso;
        this.idPaso = idPaso;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public int getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(int idPaso) {
        this.idPaso = idPaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProceso;
        hash += (int) idPaso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoDetallePK)) {
            return false;
        }
        ProcesoDetallePK other = (ProcesoDetallePK) object;
        if (this.idProceso != other.idProceso) {
            return false;
        }
        if (this.idPaso != other.idPaso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.ProcesoDetallePK[ idProceso=" + idProceso + ", idPaso=" + idPaso + " ]";
    }
    
}
