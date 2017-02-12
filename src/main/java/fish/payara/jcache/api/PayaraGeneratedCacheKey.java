/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2016 Payara Foundation and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://github.com/payara/Payara/blob/master/LICENSE.txt
 * See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * The Payara Foundation designates this particular file as subject to the "Classpath"
 * exception as provided by the Payara Foundation in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package fish.payara.jcache.api;

import java.io.Serializable;
import java.util.Arrays;
import javax.cache.annotation.CacheInvocationParameter;
import javax.cache.annotation.GeneratedCacheKey;

/**
 * Payara Generated Cache Key is the class used as keys when using JCache
 * Standard Interceptors. To interoperate between a standard injected cache
 * and a cache using Interceptors then the key type will be an instance of this
 * class
 * @author steve
 */
public class PayaraGeneratedCacheKey implements GeneratedCacheKey, Serializable {
    
    private static final long serialVersionUID = -3982698381435289430L;
    
    private final int hashCode;
    private final Object values[];
    
    /**
     * Creates an instance of Payara Generated Cache key from the specified objects
     * @param params 
     */
    public PayaraGeneratedCacheKey(Object params[]) {
        values = params;
        hashCode = Arrays.deepHashCode(values);
    }

    PayaraGeneratedCacheKey(CacheInvocationParameter[] parameters) {
        
        values = new Object[parameters.length];
        for (int i = 0; i < values.length; i++) {
            CacheInvocationParameter parameter = parameters[i];
            values[i] = parameter.getValue();
        }
        hashCode = Arrays.deepHashCode(values);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        
        if (obj == null) {
            return false;
        }
        
        if (this == obj) {
            return true;
        }
        
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        
        if (this.hashCode != obj.hashCode()) {
            return false;
        }
        
        PayaraGeneratedCacheKey other = (PayaraGeneratedCacheKey)obj;
        if (Arrays.deepEquals(this.values, other.values)) {
            return true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }
    
    
    
}
