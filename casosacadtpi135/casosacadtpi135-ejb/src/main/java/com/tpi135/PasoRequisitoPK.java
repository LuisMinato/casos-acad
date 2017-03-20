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
public class PasoRequisitoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_paso", nullable = false)
    private int idPaso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_requisito", nullable = false)
    private int idRequisito;

    public PasoRequisitoPK() {
    }

    public PasoRequisitoPK(int idPaso, int idRequisito) {
        this.idPaso = idPaso;
        this.idRequisito = idRequisito;
    }

    public int getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(int idPaso) {
        this.idPaso = idPaso;
    }

    public int getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(int idRequisito) {
        this.idRequisito = idRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPaso;
        hash += (int) idRequisito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasoRequisitoPK)) {
            return false;
        }
        PasoRequisitoPK other = (PasoRequisitoPK) object;
        if (this.idPaso != other.idPaso) {
            return false;
        }
        if (this.idRequisito != other.idRequisito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.PasoRequisitoPK[ idPaso=" + idPaso + ", idRequisito=" + idRequisito + " ]";
    }
    
}
