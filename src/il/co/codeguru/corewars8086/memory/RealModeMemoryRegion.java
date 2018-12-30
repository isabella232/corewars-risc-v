package il.co.codeguru.corewars8086.memory;

public class RealModeMemoryRegion {

    public RealModeMemoryRegion() {
        m_start = -1;
        m_end = -1;
    }

    public RealModeMemoryRegion(int start, int end) {
        m_start = start;
        m_end = end;
    }

    public boolean isInRegion(int asked) {
        return ((asked >= m_start) && (asked <= m_end));
    }

    public boolean equals(RealModeMemoryRegion a) {
        return m_start == a.m_start && m_end == a.m_end;
    }

    public int m_start;
    public int m_end; // inclusive at end
}