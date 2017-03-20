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
public class ProcesoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proceso", nullable = false)
    private int idProceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_caso", nullable = false)
    private int idCaso;

    public ProcesoPK() {
    }

    public ProcesoPK(int idProceso, int idCaso) {
        this.idProceso = idProceso;
        this.idCaso = idCaso;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
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
        hash += (int) idProceso;
        hash += (int) idCaso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoPK)) {
            return false;
        }
        ProcesoPK other = (ProcesoPK) object;
        if (this.idProceso != other.idProceso) {
            return false;
        }
        if (this.idCaso != other.idCaso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.ProcesoPK[ idProceso=" + idProceso + ", idCaso=" + idCaso + " ]";
    }
    
}
