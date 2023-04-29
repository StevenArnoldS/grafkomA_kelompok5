#version 330

out vec4 fragColor;
//uniform vec4 uni_color;
in vec4 out_color;
void main(){
    // vec4 (red, green, blue, alpha)
    // fragColor = vec4(1.0f, 0.0f, 0.0f, 1.0f);
    // fragColor = uni_color;
    fragColor = out_color;
}