/* 
 * Violation.java
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
package com.boothj5.jarch.analyser;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Violation {

    private final String message;
    private final String clazz;
    private final int lineNumber;
    private final String line;
    private final ViolationType type;
    private final String relativeFileName;

    public Violation(final String message, final String clazz, final int lineNumber, final String line,
            final ViolationType type, final String relativeFileName) {
        this.message = message;
        this.clazz = clazz;
        this.lineNumber = lineNumber;
        this.line = line;
        this.type = type;
        this.relativeFileName = relativeFileName;
    }

    public String getMessage() {
        return message;
    }

    public String getClazz() {
        return clazz;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getLine() {
        return line;
    }

    public ViolationType getType() {
        return type;
    }

    public String getRelativeFileName() {
        return relativeFileName;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        if (o == this) {
            return true;
        }

        Violation other = (Violation) o;
        return new EqualsBuilder()
            .append(this.message, other.getMessage())
            .append(this.clazz, other.getClazz())
            .append(this.lineNumber, other.getLineNumber())
            .append(this.line, other.getLine())
            .append(this.type, other.getType())
            .append(this.message, other.getMessage())
            .append(this.relativeFileName, other.getRelativeFileName())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(this.message)
            .append(this.clazz)
            .append(this.lineNumber)
            .append(this.line)
            .append(this.type)
            .append(this.message)
            .append(this.relativeFileName)
            .toHashCode();
    }

}
