package ernoDev.InventPro.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Usuario que puede iniciar sesión en el sistema.
 *
 * El password se almacena siempre cifrado con BCrypt, nunca en
 * texto plano.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String correo;
    private String username;

    // Hash BCrypt de la contraseña. @ToString.Exclude evita que el
    // toString() generado por @Data (usado en logs, prints, etc.)
    // exponga el hash accidentalmente.
    @ToString.Exclude
    private String password;

    private String telefono;

    // Si es false, el usuario no puede iniciar sesión aunque su
    // contraseña sea correcta (equivalente a "desactivar" del RF03).
    private Boolean activo;

    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}
