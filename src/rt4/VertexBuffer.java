package rt4;/* Class29 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import org.lwjgl.opengl.ARBBufferObject;
import org.peterbjornx.pgl2.util.ServerMemoryManager;
import java.nio.ByteBuffer;

public class VertexBuffer
{
    public int bufferSize = 0;
    public boolean isStream;
    public int bufferID = -1;

    public void _setArrayData(ByteBuffer arg0) {
        ARBBufferObject.glBindBufferARB(34962, bufferID);
        ARBBufferObject.glBufferDataARB(34962, arg0,  isStream ? 35040 : 35044);
        ServerMemoryManager.arbBufferMemory += arg0.limit() - bufferSize;
        bufferSize = arg0.limit();
    }

    public void setArrayData(ByteBuffer arg0) {
        if (arg0.limit() <= bufferSize) {
            ARBBufferObject.glBindBufferARB(34962, bufferID);
            ARBBufferObject.glBufferSubDataARB(34962, 0, arg0);
        } else
            _setArrayData(arg0);
    }

    public void bindArray() {
        ARBBufferObject.glBindBufferARB(34962, bufferID);
    }

    public VertexBuffer() {
        this(false);
    }

    public void finalize() throws Throwable {
        if (bufferID != -1) {
            ServerMemoryManager.requestARBBufferDeletion(bufferID, bufferSize);
            bufferID = -1;
            bufferSize = 0;
        }
        super.finalize();
    }

    public void setElementData(ByteBuffer arg0) {
        ARBBufferObject.glBindBufferARB(34963, bufferID);
        ARBBufferObject.glBufferDataARB(34963, arg0,
                isStream ? 35040 : 35044);
        ServerMemoryManager.arbBufferMemory += arg0.limit() - bufferSize;
        bufferSize = arg0.limit();
    }

    public void bindElement() {
        ARBBufferObject.glBindBufferARB(34963, bufferID);
    }

    public VertexBuffer(boolean arg0) {
        bufferID = ARBBufferObject.glGenBuffersARB();
        isStream = arg0;
    }
}
