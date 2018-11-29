package il.co.codeguru.corewars8086.cpu.riscv.instruction_formats;

import il.co.codeguru.corewars8086.utils.Logger;

public class InstructionSB extends InstructionBase{

    public InstructionSB(int raw)
    {
        super(raw);
    }

    public InstructionSB(InstructionBase i)
    {
        super(i.raw);
    }

    public InstructionSB(int opcode, int funct3, int rs1, int rs2, int imm)
    {
        super(
                (opcode & mask(7)) |
                        (((imm >> 11) & 1) << 7) |
                        (((imm >> 1) & mask(4)) << 8) |
                        ((funct3 & mask(3)) << 12) |
                        ((rs1 & mask(5)) << 15) |
                        ((rs2 & mask(5)) << 20) |
                        (((imm >> 5) & mask(6) << 25)) |
                        (((imm >> 12) & 1 ) << 31)

        );
    }

    public byte getFunct3()
    {
        return (byte)((this.raw >> 12) & mask(3));
    }

    public byte getRs1()
    {
        return (byte)((this.raw >> 15) & mask(5));
    }

    public byte getRs2()
    {
        return (byte)((this.raw >> 20) & mask(5));
    }

    public byte getImm() {
        int bit11 = (this.raw >> 7) & 1;
        int first_part = (byte)((this.raw >> 8) & mask(4));
        int bit12 = (this.raw >> 31) & 1;
        int second_part = (byte)(this.raw >> 25) & mask(6);
        return (byte)((first_part << 1) | (second_part << 5) | (bit11 << 11) | (bit12 << 12));

    }

}
