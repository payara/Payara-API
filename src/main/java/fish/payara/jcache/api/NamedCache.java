/*
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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Annotation to be applied to a Cache @Inject point to define the cache configuration
 * for the Producer to configure the cache
 *
 * @author steve
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, PARAMETER})
public @interface NamedCache {
    /**
     * The name of the Cache in the Cache Manager
     * @return cacheName
     */
    String cacheName() default "";

    /**
     * The class of the Cache Keys
     * @return keyClass
     */
    Class keyClass() default Object.class;

    /**
     * The class of the cache values
     * @return valueClass
     */
    Class valueClass() default Object.class;

    /**
     * Are statistics enabled for the cache
     * @return statisticsEnabled
     */
    boolean statisticsEnabled() default false;

    /**
     * Is Managemenet Enabled for the Cache
     * @return managementEnabled
     */
    boolean managementEnabled() default false;

    /**
     * Is the cache configured for read through. If this is set to true a CacheLoader factory
     * class must also be specified
     * @return readThrough
     */
    boolean readThrough() default false;

    /**
     * Is the cache configured for write through. If this is set a CacheWriter factory
     * class must be specified
     * @return writeThrough
     */
    boolean writeThrough() default false;

    /**
     * The factory class of the CacheLoader to be attached to the cache
     * @return cacheLoaderFactoryClass
     */
    Class cacheLoaderFactoryClass() default Object.class;

    /**
     * The factory class of the CacheWriter to be attached to the cache
     * @return cacheWriterFactoryClass
     */
    Class cacheWriterFactoryClass() default Object.class;

    /**
     * The class of the expiry policy factory used to create an expiry policy for the cache
     * @return expiryPolicyFactoryClass
     */
    Class expiryPolicyFactoryClass() default Object.class;
}