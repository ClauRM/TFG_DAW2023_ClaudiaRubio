# TFG DAW2023 | Claudia Rubio

Trabajo final de grado (TFG) superior Desarrollo de Aplicaciones Web | Gestor de tratamiento médico


SELECT medicamento, composicion, unidad, paciente, dosis, horas, observaciones FROM medicamentos m INNER JOIN tratamientos t ON t.fidmedicamento = m.idmedicamento

SELECT * FROM medicamentos m INNER JOIN tratamientos t ON t.fidmedicamento = m.idmedicamento