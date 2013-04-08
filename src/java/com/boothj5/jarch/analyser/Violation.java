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
        return this.clazz == other.clazz
                && this.line == other.line
                && this.lineNumber == other.lineNumber
                && this.message == other.message
                && this.relativeFileName == other.relativeFileName
                && this.type == other.type;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + (this.message == null ? 0 : this.message.hashCode());
        hash = hash * 3 + (this.clazz == null ? 0 : this.clazz.hashCode());
        hash = hash * 5 + this.lineNumber;
        hash = hash * 13 + (this.line == null ? 0 : this.line.hashCode());
        hash = hash * 3 + (this.type == null ? 0 : this.type.hashCode());
        hash = hash * 5 + (this.relativeFileName == null ? 0 : this.relativeFileName.hashCode());

        return hash;
    }

    @Override
    public String toString() {
        String msg = "Violation::";
            msg = msg + " type[" +this.type + "]";
            msg = msg + " class[" +this.clazz + "]";
            msg = msg + " file[" +this.relativeFileName + "]";
            msg = msg + " line[" +this.line + "]";
            msg = msg + " lineNumber[" +this.lineNumber + "]";
            msg = msg + " message[" +this.message + "]";
            return msg;
    }

}
