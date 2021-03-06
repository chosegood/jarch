/* 
 * CircularDepedency.java
 *
 * Copyright (C) 2012 James Booth <boothj5@gmail.com>
 * 
 * This file is part of JArch.
 *
 * JArch is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JArch is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JArch.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.boothj5.jarch.configuration;

import static com.boothj5.jarch.util.ArgumentValidator.*;

public class CircularDepedency {
    private final String moduleA;
    private final String moduleB;

    public CircularDepedency(String moduleA, String moduleB) {
        notNullOrEmpty(moduleA, "ModuleA must not be null or empty");
        notNullOrEmpty(moduleB, "ModuleB must not be null or empty");
        this.moduleA = moduleA;
        this.moduleB = moduleB;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof CircularDepedency))
            return false;

        CircularDepedency other = (CircularDepedency) o;
        
        if (this.moduleA.equals(other.moduleA) && this.moduleB.equals(other.moduleB)) {
            return true;
        } else if (this.moduleA.equals(other.moduleB) && this.moduleB.equals(other.moduleA)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return moduleA.hashCode() + moduleB.hashCode();
    }
    
    public String getModuleA() {
        return moduleA;
    }

    public String getModuleB() {
        return moduleB;
    }
}