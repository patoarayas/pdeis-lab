/*
 * Copyright (c) 2020 Diego Urrutia-Astorga. http://durrutia.cl.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package cl.ucn.disc.pdis.lab.services;

import cl.ucn.disc.pdis.lab.zeroice.model.Engine;
import com.zeroc.Ice.Current;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The implementation of {@link cl.ucn.disc.pdis.lab.zeroice.model.Engine}.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class EngineImpl implements Engine {

    /**
     * @see Engine#getDate(Current)
     */
    @Override
    public String getDate(Current current) {

        return ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    @Override
    public String getDigitoVerificador(String rut, Current current) {

        if (rut.length() == 0) {
            return "ERROR: Rut es null";
        }

        int sum = 0;
        for (int i = rut.length() - 1; i >= 0; i--) {
           int digito;
           try {
               digito = Integer.parseInt(String.valueOf(rut.charAt(i)));
           } catch (NumberFormatException e){
               return "ERROR: Rut contiene valores no númericos";
           }
            sum += digito * (((rut.length() - (i + 1)) % 6) + 2);
        }

        int mod = 11 - (sum % 11);

        String dv = null;
        if (mod == 11) {
            dv = "0";
        } else if (mod == 10) {
            dv = "K";
        } else {
            dv = Integer.toString(mod);
        }
        return dv;

    }

}
