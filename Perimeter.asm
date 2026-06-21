section .data
    ; Menu and Prompts
    menu_msg        db 10, "Of which shape do you want to find perimeter of?", 10, \
                       "[1] Rectangle", 10, \
                       "[2] Triangle", 10, \
                       "[3] Square", 10, \
                       "[0] Exit", 10, \
                       10, "Please Select an option", 10, "> ", 0
    
    rect_l_msg      db "Enter the length of the rectangle:", 10, "> ", 0
    rect_w_msg      db "Enter the Width of the rectangle:", 10, "> ", 0
    tri_a_msg       db "Enter side a of the triangle:", 10, "> ", 0
    tri_b_msg       db "Enter side b of the triangle:", 10, "> ", 0
    tri_c_msg       db "Enter side c of the triangle:", 10, "> ", 0
    square_msg      db "Enter the side of the square:", 10, "> ", 0

    ; Error messages and output formats
    err_int_msg     db "ERR This field only accepts numbers. Please try again.", 10, 0
    err_pos_msg     db "ERR: Value must be positive", 10, "> ", 0
    err_choice_msg  db "ERR: Invalid option selected. Please try again.", 10, 0
    err_tri_msg     db "ERR: Invalid Triangle", 10, 0
    goodbye_msg     db "Goodbye!", 10, 0

    res_rect_msg    db "The perimeter of the rectangle is %d", 10, 0
    res_tri_msg     db "The perimeter of the triangle is %d", 10, 0
    res_square_msg  db "The perimeter of the square is %d", 10, 0

    fmt_int         db "%d", 0

section .bss
    choice          resd 1
    temp_val        resd 1
    side_a          resd 1
    side_b          resd 1
    side_c          resd 1

section .text
    global main
    extern printf, scanf, getchar

main:
    push rbp
    mov rbp, rsp

.main_loop:
    ; Print Menu
    mov rdi, menu_msg
    xor eax, eax
    call printf

    ; Get choice input
    call getPositiveInt
    mov [choice], eax

    ; Switch logic
    mov eax, [choice]   
    cmp eax, 0
    je .exit_prog
    cmp eax, 1
    je .case_rectangle
    cmp eax, 2
    je .case_triangle
    cmp eax, 3
    je .case_square

    ; Default case
    mov rdi, err_choice_msg
    xor eax, eax
    call printf
    jmp .main_loop

.case_rectangle:
    mov rdi, rect_l_msg
    xor eax, eax
    call printf
    call getPositiveInt
    mov ebx, eax            ; Store length in ebx

    mov rdi, rect_w_msg
    xor eax, eax
    call printf
    call getPositiveInt     ; Width in eax

    ; Calculate Rectangle Perimeter: 2 * (l + w)
    add eax, ebx
    shl eax, 1              ; Multiply by 2

    mov rdi, res_rect_msg
    mov esi, eax
    xor eax, eax
    call printf
    jmp .main_loop

.case_triangle:
    mov rdi, tri_a_msg
    xor eax, eax
    call printf
    call getPositiveInt
    mov [side_a], eax

    mov rdi, tri_b_msg
    xor eax, eax
    call printf
    call getPositiveInt
    mov [side_b], eax

    mov rdi, tri_c_msg
    xor eax, eax
    call printf
    call getPositiveInt
    mov [side_c], eax

    ; Triangle Inequality Validation
    mov edx, [side_a]
    mov ecx, [side_b]
    mov r8d, [side_c]

    ; a + b <= c
    mov eax, edx
    add eax, ecx
    cmp eax, r8d
    jle .invalid_triangle

    ; a + c <= b
    mov eax, edx
    add eax, r8d
    cmp eax, ecx
    jle .invalid_triangle

    ; b + c <= a
    mov eax, ecx
    add eax, r8d
    cmp eax, edx
    jle .invalid_triangle

    ; Calculate Triangle Perimeter: a + b + c
    mov eax, [side_a]
    add eax, [side_b]
    add eax, [side_c]

    mov rdi, res_tri_msg
    mov esi, eax
    xor eax, eax
    call printf
    jmp .main_loop

.invalid_triangle:
    mov rdi, err_tri_msg
    xor eax, eax
    call printf
    jmp .exit_prog

.case_square:
    mov rdi, square_msg
    xor eax, eax
    call printf
    call getPositiveInt

    ; Calculate Square Perimeter: 4 * a
    shl eax, 2              ; Multiply by 4

    mov rdi, res_square_msg
    mov esi, eax
    xor eax, eax
    call printf
    jmp .main_loop

.exit_prog:
    mov rdi, goodbye_msg
    xor eax, eax
    call printf

    mov rsp, rbp
    pop rbp
    xor eax, eax
    ret

; --- Helper Function: getPositiveInt ---
; Emulates Java's checkInt and positive validation loops
getPositiveInt:
    push rbp
    mov rbp, rsp

.read_input:
    mov rdi, fmt_int
    mov rsi, temp_val
    xor eax, eax
    call scanf

    cmp eax, 1
    je .check_positive

    ; If scanf failed (not an integer), clear buffer
    mov rdi, err_int_msg
    xor eax, eax
    call printf

.clear_buffer:
    call getchar
    cmp al, 10              ; Loop until newline
    jne .clear_buffer
    jmp .read_input

.check_positive:
    mov eax, [temp_val]
    cmp eax, 0
    jg .valid_end

    mov rdi, err_pos_msg
    xor eax, eax
    call printf
    jmp .read_input

.valid_end:
    mov eax, [temp_val]     ; Return value in eax
    mov rsp, rbp
    pop rbp
    ret