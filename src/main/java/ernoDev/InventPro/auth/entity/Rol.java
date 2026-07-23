package ernoDev.InventPro.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Rol de acceso de un usuario dentro del sistema.
 *
 * Ejemplos: Administrador, Bodeguero, Gerente.
 * Se usa junto con Spring Security para restringir endpoints
 * según el rol autenticado.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
}