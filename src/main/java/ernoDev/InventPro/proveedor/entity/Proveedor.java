package ernoDev.InventPro.proveedor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un proveedor de productos para la empresa.
 *
 * Contiene la información de contacto necesaria para relacionar
 * productos con su origen.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Número de Identificación Tributaria. Es el identificador único
    // de negocio del proveedor (distinto del id técnico autogenerado).
    private String nit;

    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private String ciudad;

    // true = proveedor activo, false = inactivo (se conserva el
    // historial de productos asociados, pero no se debería usar
    // para nuevos productos).
    private Boolean estado;
}