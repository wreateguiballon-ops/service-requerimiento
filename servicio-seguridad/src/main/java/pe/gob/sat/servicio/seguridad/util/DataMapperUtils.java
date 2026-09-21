package pe.gob.sat.servicio.seguridad.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DataMapperUtils {
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private DataMapperUtils() {
        // Clase utilitaria, previene instanciación
    }

    public static Integer toInteger(Object val) {
        if (val == null) return null;
        if (val instanceof Number n) return n.intValue();
        if (val instanceof String s && !s.trim().isEmpty()) {
            return Integer.parseInt(s.trim());
        }
        return null;
    }

    public static String parseString(Object val) {
        return val != null ? val.toString().trim() : null;
    }

    public static LocalDateTime toLocalDateTime(Object val) {
        if (val == null) return null;
        if (val instanceof Timestamp ts) return ts.toLocalDateTime();
        if (val instanceof LocalDateTime ldt) return ldt;
        if (val instanceof Date d) return new Timestamp(d.getTime()).toLocalDateTime();
        if (val instanceof String s && !s.trim().isEmpty()) {
            return LocalDateTime.parse(s.trim(), DEFAULT_DATETIME_FORMATTER);
        }
        return null;
    }
    public static Double toDouble(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).doubleValue(); // <-- Conversión explícita
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        try {
            return new BigDecimal(value.toString()).doubleValue();
        } catch (NumberFormatException e) {
            return null;
        }
    }
    public static BigDecimal toBigDecimal(Object value) {
        if (value == null) {
            return null; // O BigDecimal.ZERO si prefieres un valor por defecto
        }
        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        }
        if (value instanceof Number) {
            return BigDecimal.valueOf(((Number) value).doubleValue());
        }
        try {
            return new BigDecimal(value.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }
    public static Boolean toBoolean(Object value) {
        if (value == null) {
            return false; // O null si prefieres permitir nulos
        }
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue() != 0;
        }
        if (value instanceof String) {
            String str = ((String) value).trim();
            return str.equalsIgnoreCase("true") || str.equals("1");
        }
        return Boolean.parseBoolean(value.toString());
    }


    public static void appendIfNotNull(StringBuilder sb, String attrName, Object value) {
        if (value != null) {
            sb.append(String.format(" %s=\"%s\"", attrName, escapeXml(value.toString())));
        }
    }

    public static void appendIfNotNull(StringBuilder sb, String attrName, LocalDateTime value) {
        if (value != null) {
            String formattedDate = value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            sb.append(String.format(" %s=\"%s\"", attrName, formattedDate));
        }
    }

    public static void appendIfNotNull(StringBuilder sb, String attrName, Boolean value) {
        if (value != null) {
            // Convierte Boolean a "1" o "0" para SQL Server o déjalo como value.toString() según prefiera tu SP
            int intValue = value ? 1 : 0;
            sb.append(String.format(" %s=\"%d\"", attrName, intValue));
        }
    }

    public static String escapeXml(String input) {
        if (input == null) return "";
        return input.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}