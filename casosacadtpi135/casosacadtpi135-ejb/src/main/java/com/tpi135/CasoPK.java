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
public class CasoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_caso", nullable = false)
    private int idCaso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_solicitud", nullable = false)
    private int idSolicitud;

    public CasoPK() {
    }

    public CasoPK(int idCaso, int idSolicitud) {
        this.idCaso = idCaso;
        this.idSolicitud = idSolicitud;
    }

    public int getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(int idCaso) {
        this.idCaso = idCaso;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCaso;
        hash += (int) idSolicitud;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoPK)) {
            return false;
        }
        CasoPK other = (CasoPK) object;
        if (this.idCaso != other.idCaso) {
            return false;
        }
        if (this.idSolicitud != other.idSolicitud) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.CasoPK[ idCaso=" + idCaso + ", idSolicitud=" + idSolicitud + " ]";
    }
    
}
