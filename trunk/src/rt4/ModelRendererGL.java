package rt4;/* Class133_Sub7_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import org.lwjgl.opengl.ARBBufferObject;
import org.lwjgl.opengl.GL11;
import pgle.PglSun;
import rs2.*;
import sun.plugin.com.Utils;

import java.nio.ByteBuffer;

public class ModelRendererGL {
    public boolean aBoolean5009;
    public int[] vertexZ;
    public static Packet vertexBuffer = new Packet(new byte[10000]);
    public float[] textureV;
    public ModelBounds bounds;
    public int triangleCount = 0;
    public int[][] triangleSkin;
    public byte[] triangleTSkin;
    public short[] normalMagnitude;
    public VertexBufferPointer vertexNormals;
    public short[] normalY;
    public VertexBuffer hardwareVertexBuffer;
    public short[] triangleA;
    public int[] vertexY;
    public byte dirtyBuffers;
    public short falloff;
    public short[] triangleB;
    public byte aByte5026;
    public int[] vertexX;
    public VertexBufferPointer vertexPositions;
    public VertexBufferPointer vertexTexCoords;
    public VertexBufferPointer vertexColours;
    public int[] vertexUsageCount;
    public short intensity;
    public int realVertexCount;
    public int[] vertexVSkin;
    public int[] textureTriangles;
    public short[] vertexIndexes;
    public short[] triangleTexture;
    public short[] triangleC;
    public Normals aNormals_5039;
    public int vertexCount;
    public short[] normalX;
    public short[] normalZ;
    public byte[] triangleAlpha;
    public int[][] vertexSkin;
    public short[] triangleColour;
    public VertexBufferPointer triangleIndices;
    public float[] textureU;
    public static long[] aLongArray5048;
    public static ModelRendererGL aModelRendererGL_5049 = new ModelRendererGL();
    public static ByteBuffer vertexArrayBuffer;
    public static ModelRendererGL aModelRendererGL_5051 = new ModelRendererGL();
    public static ModelRendererGL aModelRendererGL_5052 = new ModelRendererGL();
    public static ModelRendererGL aModelRendererGL_5053 = new ModelRendererGL();
    public static int vertexZModifier;
    public static int vertexXModifier;
    public static float aFloat5056;
    public static int[] anIntArray5057;
    public static float aFloat5058;
    public static int vertexYModifier;
    public static float aFloat5060;
    public static int[] anIntArray5061 = new int[1];
    public static float aFloat5062;
    public static float aFloat5063;
    public static float aFloat5064;

    public void render() {
        if (triangleCount != 0) {
            if (aByte5026 != 0)
                updateBuffers(true, (!vertexPositions.upToDate && (aByte5026 & 0x1) != 0), (!vertexColours.upToDate && (aByte5026 & 0x2) != 0), (vertexNormals != null && !vertexNormals.upToDate && (aByte5026 & 0x4) != 0), false);
            updateBuffers(false, !vertexPositions.upToDate, !vertexColours.upToDate, vertexNormals != null && !vertexNormals.upToDate, !vertexTexCoords.upToDate);
            if (!triangleIndices.upToDate)
                updateElementBuffer();
            if (dirtyBuffers != 0) {
                if ((dirtyBuffers & 0x1) != 0) {
                    vertexX = null;
                    vertexY = null;
                    vertexZ = null;
                    vertexIndexes = null;
                    vertexUsageCount = null;
                }
                if ((dirtyBuffers & 0x2) != 0) {
                    triangleColour = null;
                    triangleAlpha = null;
                }
                if ((dirtyBuffers & 0x4) != 0) {
                    normalX = null;
                    normalY = null;
                    normalZ = null;
                    normalMagnitude = null;
                }
                if ((dirtyBuffers & 0x8) != 0) {
                    textureU = null;
                    textureV = null;
                }
                if ((dirtyBuffers & 0x10) != 0) {
                    triangleA = null;
                    triangleB = null;
                    triangleC = null;
                }
                dirtyBuffers = (byte) 0;
            }
            VertexBuffer vertexBuffer = null;
            if (vertexPositions.vertexBuffer != null) {
                vertexPositions.vertexBuffer.bindArray();
                vertexBuffer = vertexPositions.vertexBuffer;
                GL11.glVertexPointer(3, 5126, vertexPositions.stride, (long) vertexPositions.offset);
            }
            if (vertexColours.vertexBuffer != null) {
                if (vertexBuffer != vertexColours.vertexBuffer) {
                    vertexColours.vertexBuffer.bindArray();
                    vertexBuffer = vertexColours.vertexBuffer;
                }
                GL11.glColorPointer(4, 5121, vertexColours.stride, (long) vertexColours.offset);
            }
            if (Class7_Sub1.useLighting && vertexNormals.vertexBuffer != null) {
                if (vertexBuffer != vertexNormals.vertexBuffer) {
                    vertexNormals.vertexBuffer.bindArray();
                    vertexBuffer = vertexNormals.vertexBuffer;
                }
                GL11.glNormalPointer(5126, vertexNormals.stride, (long) vertexNormals.offset);
            }
            if (vertexTexCoords.vertexBuffer != null) {
                if (vertexBuffer != vertexTexCoords.vertexBuffer) {
                    vertexTexCoords.vertexBuffer.bindArray();
                    vertexBuffer = vertexTexCoords.vertexBuffer;
                }
                GL11.glTexCoordPointer(2, 5126, vertexTexCoords.stride, (long) vertexTexCoords.offset);
            }
            if (triangleIndices.vertexBuffer != null)
                triangleIndices.vertexBuffer.bindElement();
            if (vertexPositions.vertexBuffer == null || vertexColours.vertexBuffer == null || (Class7_Sub1.useLighting && vertexNormals.vertexBuffer == null) || vertexTexCoords.vertexBuffer == null) {
                if (OpenGLManager.has_vbo)
                    ARBBufferObject.glBindBufferARB(34962, 0);
                if (vertexPositions.vertexBuffer == null) {
                    vertexPositions.array.position(vertexPositions.offset);
                    GL11.glVertexPointer(3, vertexPositions.stride, vertexPositions.array.asFloatBuffer());
                }
                if (vertexColours.vertexBuffer == null) {
                    vertexColours.array.position(vertexColours.offset);
                    GL11.glColorPointer(4, true,vertexColours.stride, vertexColours.array);
                }
                if (Class7_Sub1.useLighting && vertexNormals.vertexBuffer == null) {
                    vertexNormals.array.position(vertexNormals.offset);
                    GL11.glNormalPointer(vertexNormals.stride, vertexNormals.array.asFloatBuffer());
                }
                if (vertexTexCoords.vertexBuffer == null) {
                    vertexTexCoords.array.position(vertexTexCoords.offset);
                    GL11.glTexCoordPointer(2, vertexTexCoords.stride, vertexTexCoords.array.asFloatBuffer());
                }
            }
            if (triangleIndices.vertexBuffer == null && OpenGLManager.has_vbo)
                ARBBufferObject.glBindBufferARB(34963, 0);
            int i = textureTriangles.length - 1;
            for (int textureInstancePtr = 0; textureInstancePtr < i; textureInstancePtr++) {
                int triangleId = textureTriangles[textureInstancePtr];
                int nextTriangleId = textureTriangles[textureInstancePtr + 1];
                int textureId = triangleTexture[triangleId];
                if (textureId == -1) {
                    //GL11.glDisable(GL11.GL_TEXTURE_2D);
                } else
                    TextureSource.bindtexture(textureId & 0xffff);
                if (triangleIndices.vertexBuffer != null)
                    GL11.glDrawElements(4, (nextTriangleId - triangleId) * 3, 5125, (long) (triangleId * 12));
                else {
                    //triangleIndices.array.position(triangleId * 12);
                    int limit = triangleIndices.array.limit();
                   // triangleIndices.array.limit((triangleId * 12)+(nextTriangleId - triangleId));
                    GL11.glDrawElements(GL11.GL_TRIANGLES,triangleIndices.array.asIntBuffer());//todo: 4
                   // triangleIndices.array.limit(limit);
                }
            }
        }
    }

    public void renderInWorld(int xAngle, int yAngle, int zAngle, int localXAngle, int xPos, int yPos, int zPos) {
        if (vertexCount != 0) {
            GL11.glPushMatrix();
            if (localXAngle != 0)
                GL11.glRotatef((float) localXAngle * 0.17578125F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef((float) xPos, (float) yPos, (float) zPos);
            if (yAngle != 0)
                GL11.glRotatef((float) yAngle * 0.17578125F, 0.0F, 1.0F, 0.0F);
            if (xAngle != 0)
                GL11.glRotatef((float) xAngle * 0.17578125F, 1.0F, 0.0F, 0.0F);
            if (zAngle != 0)
                GL11.glRotatef((float) -zAngle * 0.17578125F, 0.0F, 0.0F, 1.0F);
            render();
            GL11.glPopMatrix();
        }
    }

    public static void method1888(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, float[] arg7, int arg8, float arg9, float arg10, float arg11) {
        arg0 -= arg3;
        arg1 -= arg4;
        arg2 -= arg5;
        float f = ((float) arg0 * arg7[0] + (float) arg1 * arg7[1] + (float) arg2 * arg7[2]);
        float f_4_ = ((float) arg0 * arg7[3] + (float) arg1 * arg7[4] + (float) arg2 * arg7[5]);
        float f_5_ = ((float) arg0 * arg7[6] + (float) arg1 * arg7[7] + (float) arg2 * arg7[8]);
        float f_6_;
        float f_7_;
        if (arg6 == 0) {
            f_6_ = f + arg9 + 0.5F;
            f_7_ = -f_5_ + arg11 + 0.5F;
        } else if (arg6 == 1) {
            f_6_ = f + arg9 + 0.5F;
            f_7_ = f_5_ + arg11 + 0.5F;
        } else if (arg6 == 2) {
            f_6_ = -f + arg9 + 0.5F;
            f_7_ = -f_4_ + arg10 + 0.5F;
        } else if (arg6 == 3) {
            f_6_ = f + arg9 + 0.5F;
            f_7_ = -f_4_ + arg10 + 0.5F;
        } else if (arg6 == 4) {
            f_6_ = f_5_ + arg11 + 0.5F;
            f_7_ = -f_4_ + arg10 + 0.5F;
        } else {
            f_6_ = -f_5_ + arg11 + 0.5F;
            f_7_ = -f_4_ + arg10 + 0.5F;
        }
        if (arg8 == 1) {
            float f_8_ = f_6_;
            f_6_ = -f_7_;
            f_7_ = f_8_;
        } else if (arg8 == 2) {
            f_6_ = -f_6_;
            f_7_ = -f_7_;
        } else if (arg8 == 3) {
            float f_9_ = f_6_;
            f_6_ = f_7_;
            f_7_ = -f_9_;
        }
        aFloat5056 = f_6_;
        aFloat5063 = f_7_;
    }
     /*
    public Class148_Sub1 method1889(Class148_Sub1 arg0) {
        if (vertexCount == 0)
            return null;
        if (!bounds.upToDate)
            updateBounds();
        int i;
        int i_10_;
        if (AthmosphericEffects.anInt934 > 0) {
            i = (bounds.maxX - (bounds.minY * PglSun.anInt934 >> 8)) >> 3;
            i_10_ = (bounds.minX - (bounds.maxY * PglSun.anInt934 >> 8)) >> 3;
        } else {
            i = (bounds.maxX - (bounds.maxY * PglSun.anInt934 >> 8)) >> 3;
            i_10_ = (bounds.minX - (bounds.minY * PglSun.anInt934 >> 8)) >> 3;
        }
        int i_11_;
        int i_12_;
        if (AthmosphericEffects.anInt928 > 0) {
            i_11_ = (bounds.maxZ - (bounds.minY * PglSun.anInt928 >> 8)) >> 3;
            i_12_ = (bounds.minZ - (bounds.maxY * PglSun.anInt928 >> 8)) >> 3;
        } else {
            i_11_ = (bounds.maxZ - (bounds.maxY * PglSun.anInt928 >> 8)) >> 3;
            i_12_ = (bounds.minZ - (bounds.minY * PglSun.anInt928 >> 8)) >> 3;
        }
        int i_13_ = i_10_ - i + 1;
        int i_14_ = i_12_ - i_11_ + 1;
        Class148_Sub1 class148_sub1;
        if (arg0 != null && arg0.aByteArray3689.length >= i_13_ * i_14_) {
            class148_sub1 = arg0;
            class148_sub1.anInt2378 = class148_sub1.v1_x = i_13_;
            class148_sub1.anInt2373 = class148_sub1.v1_y = i_14_;
            class148_sub1.method2010();
        } else
            class148_sub1 = new Class148_Sub1(i_13_, i_14_, 0);
        class148_sub1.x_offset = i;
        class148_sub1.y_offset = i_11_;
        if (anIntArray5061.length < vertexCount) {
            anIntArray5061 = new int[vertexCount];
            anIntArray5057 = new int[vertexCount];
        }
        for (int i_15_ = 0; i_15_ < realVertexCount; i_15_++) {
            int i_16_ = (((vertexX[i_15_] - (vertexY[i_15_] * PglSun.anInt934 >> 8)) >> 3) - i);
            int i_17_ = (((vertexZ[i_15_] - (vertexY[i_15_] * PglSun.anInt928 >> 8)) >> 3) - i_11_);
            int i_18_ = vertexUsageCount[i_15_];
            int i_19_ = vertexUsageCount[i_15_ + 1];
            for (int i_20_ = i_18_; i_20_ < i_19_; i_20_++) {
                int i_21_ = vertexIndexes[i_20_] - 1;
                if (i_21_ == -1)
                    break;
                anIntArray5061[i_21_] = i_16_;
                anIntArray5057[i_21_] = i_17_;
            }
        }
        for (int i_22_ = 0; i_22_ < triangleCount; i_22_++) {
            if (triangleAlpha[i_22_] <= 128) {
                short i_23_ = triangleA[i_22_];
                short i_24_ = triangleB[i_22_];
                short i_25_ = triangleC[i_22_];
                int i_26_ = anIntArray5061[i_23_];
                int i_27_ = anIntArray5061[i_24_];
                int i_28_ = anIntArray5061[i_25_];
                int i_29_ = anIntArray5057[i_23_];
                int i_30_ = anIntArray5057[i_24_];
                int i_31_ = anIntArray5057[i_25_];
                if (((i_26_ - i_27_) * (i_30_ - i_31_) - (i_30_ - i_29_) * (i_28_ - i_27_)) > 0)
                    Rasterizer.method91(class148_sub1.aByteArray3689, i_29_, i_30_, i_31_, i_26_, i_27_, i_28_, i_13_);
            }
        }
        return class148_sub1;
    }
    */
    public void rotateWithNormalsCCW() {
        if (normalX == null)
            rotateCCW();
        else {
            for (int i = 0; i < realVertexCount; i++) {
                int i_32_ = vertexZ[i];
                vertexZ[i] = vertexX[i];
                vertexX[i] = -i_32_;
            }
            for (int i = 0; i < vertexCount; i++) {
                int i_33_ = normalZ[i];
                normalZ[i] = normalX[i];
                normalX[i] = (short) -i_33_;
            }
            bounds.upToDate = false;
            vertexPositions.upToDate = false;
            if (vertexNormals != null)
                vertexNormals.upToDate = false;
        }
    }

    public void updateBounds() {
        int maxX = 32767;
        int maxY = 32767;
        int maxZ = 32767;
        int minX = -32768;
        int minY = -32768;
        int minZ = -32768;
        int surface = 0;
        int volume = 0;
        for (int vertexPtr = 0; vertexPtr < realVertexCount; vertexPtr++) {
            int x = vertexX[vertexPtr];
            int y = vertexY[vertexPtr];
            int z = vertexZ[vertexPtr];
            if (x < maxX)
                maxX = x;
            if (x > minX)
                minX = x;
            if (y < maxY)
                maxY = y;
            if (y > minY)
                minY = y;
            if (z < maxZ)
                maxZ = z;
            if (z > minZ)
                minZ = z;
            int i = x * x + z * z;
            if (i > surface)
                surface = i;
            i = x * x + z * z + y * y;
            if (i > volume)
                volume = i;
        }
        bounds.maxX = (short) maxX;
        bounds.minX = (short) minX;
        bounds.maxY = (short) maxY;
        bounds.minY = (short) minY;
        bounds.maxZ = (short) maxZ;
        bounds.minZ = (short) minZ;
        bounds.diagonal = (short) (int) (Math.sqrt((double) surface) + 0.99);
        Math.sqrt((double) volume);
        bounds.upToDate = true;
    }

    public void method1892(int arg0) {
        intensity = (short) arg0;
        vertexColours.upToDate = false;
    }

    public void applyVertex(int mode, int xOffset, int yOffset, int zOffset) {
        if (mode == 0) {
            int vertexAddedCount = 0;
            vertexXModifier = 0;
            vertexYModifier = 0;
            vertexZModifier = 0;
            for (int vertexIdx = 0; vertexIdx < realVertexCount; vertexIdx++) {
                vertexXModifier += vertexX[vertexIdx];
                vertexYModifier += vertexY[vertexIdx];
                vertexZModifier += vertexZ[vertexIdx];
                vertexAddedCount++;
            }
            if (vertexAddedCount > 0) {
                vertexXModifier = vertexXModifier / vertexAddedCount + xOffset;
                vertexYModifier = vertexYModifier / vertexAddedCount + yOffset;
                vertexZModifier = vertexZModifier / vertexAddedCount + zOffset;
            } else {
                vertexXModifier = xOffset;
                vertexYModifier = yOffset;
                vertexZModifier = zOffset;
            }
        } else if (mode == 1) {
            for (int i = 0; i < realVertexCount; i++) {
                vertexX[i] += xOffset;
                vertexY[i] += yOffset;
                vertexZ[i] += zOffset;
            }
        } else if (mode == 2) {
            for (int i = 0; i < realVertexCount; i++) {
                vertexX[i] -= vertexXModifier;
                vertexY[i] -= vertexYModifier;
                vertexZ[i] -= vertexZModifier;
                if (zOffset != 0) {
                    int i_47_ = Rasterizer.SINE[zOffset];
                    int i_48_ = Rasterizer.COSINE[zOffset];
                    int i_49_ = ((vertexY[i] * i_47_ + vertexX[i] * i_48_ + 32767) >> 16);
                    vertexY[i] = (vertexY[i] * i_48_ - vertexX[i] * i_47_ + 32767) >> 16;
                    vertexX[i] = i_49_;
                }
                if (xOffset != 0) {
                    int i_50_ = Rasterizer.SINE[xOffset];
                    int i_51_ = Rasterizer.COSINE[xOffset];
                    int i_52_ = ((vertexY[i] * i_51_ - vertexZ[i] * i_50_ + 32767) >> 16);
                    vertexZ[i] = (vertexY[i] * i_50_ + vertexZ[i] * i_51_ + 32767) >> 16;
                    vertexY[i] = i_52_;
                }
                if (yOffset != 0) {
                    int i_53_ = Rasterizer.SINE[yOffset];
                    int i_54_ = Rasterizer.COSINE[yOffset];
                    int i_55_ = ((vertexZ[i] * i_53_ + vertexX[i] * i_54_ + 32767) >> 16);
                    vertexZ[i] = (vertexZ[i] * i_54_ - vertexX[i] * i_53_ + 32767) >> 16;
                    vertexX[i] = i_55_;
                }
                vertexX[i] += vertexXModifier;
                vertexY[i] += vertexYModifier;
                vertexZ[i] += vertexZModifier;
            }
        } else if (mode == 3) {
            for (int i = 0; i < realVertexCount; i++) {
                vertexX[i] -= vertexXModifier;
                vertexY[i] -= vertexYModifier;
                vertexZ[i] -= vertexZModifier;
                vertexX[i] = vertexX[i] * xOffset / 128;
                vertexY[i] = vertexY[i] * yOffset / 128;
                vertexZ[i] = vertexZ[i] * zOffset / 128;
                vertexX[i] += vertexXModifier;
                vertexY[i] += vertexYModifier;
                vertexZ[i] += vertexZModifier;
            }
        } else if (mode == 5) {
            for (int i = 0; i < triangleCount; i++) {
                int i_56_ = (triangleAlpha[i] & 0xff) + xOffset * 8;
                if (i_56_ < 0)
                    i_56_ = 0;
                else if (i_56_ > 255)
                    i_56_ = 255;
                triangleAlpha[i] = (byte) i_56_;
            }
            vertexColours.upToDate = false;
        }
    }

    public static float[] subArray(float[] source, int length) {
        float[] dest = new float[length];
        System.arraycopy(source, 0, dest, 0, length);
        return dest;
    }

    public void mixAnimationFrames(int frame1, int frame2, int[] framesFrom2, boolean arg5) {
        if (frame1 != -1) {
            if (framesFrom2 == null || frame2 == -1)
                applyTransform(frame1, arg5);
            else {
                Animation animation = Animation.forID(frame1);//GL11
                Animation animation_57_ = Animation.forID(frame2);
                ModelTransform modelTransform = animation.myModelTransform;
                for (int i = 0; i < realVertexCount; i++) {
                    vertexX[i] <<= 4;
                    vertexY[i] <<= 4;
                    vertexZ[i] <<= 4;
                }
                vertexXModifier = 0;
                vertexYModifier = 0;
                vertexZModifier = 0;
                int i = 0;
                int i_58_ = framesFrom2[i++];
                for (int i_59_ = 0; i_59_ < animation.stepCount; i_59_++) {
                    int i_60_;
                    for (i_60_ = animation.opcodeLinkTable[i_59_]; i_60_ > i_58_; i_58_ = framesFrom2[i++]) {
                        /* empty */
                    }
                    if (i_60_ != i_58_ || modelTransform.opcodes[i_60_] == 0) {
                        //if (animation.aShortArray2338[i_59_] != -1)
                        //    transformStep(0, (modelTransform.skinList[animation.aShortArray2338[i_59_]]), 0, 0, 0, arg5);
                        transformStep(modelTransform.opcodes[i_60_], modelTransform.skinList[i_60_], animation.modifier1[i_59_], animation.modifier2[i_59_], animation.modifier3[i_59_], arg5);
                    }
                }
                vertexXModifier = 0;
                vertexYModifier = 0;
                vertexZModifier = 0;
                i = 0;
                i_58_ = framesFrom2[i++];
                for (int i_61_ = 0; i_61_ < animation_57_.stepCount; i_61_++) {
                    int i_62_;
                    for (i_62_ = animation_57_.opcodeLinkTable[i_61_]; i_62_ > i_58_; i_58_ = framesFrom2[i++]) {
                        /* empty */
                    }
                    if (i_62_ == i_58_ || modelTransform.opcodes[i_62_] == 0) {
                        //if (animation_57_.aShortArray2338[i_61_] != -1)
                        //    transformStep(0, (modelTransform.skinList[animation_57_.aShortArray2338[i_61_]]), 0, 0, 0, arg5);
                        transformStep(modelTransform.opcodes[i_62_], modelTransform.skinList[i_62_], animation_57_.modifier1[i_61_], animation_57_.modifier2[i_61_], animation_57_.modifier3[i_61_], arg5);
                    }
                }
                for (int i_63_ = 0; i_63_ < realVertexCount; i_63_++) {
                    vertexX[i_63_] >>= 4;
                    vertexY[i_63_] >>= 4;
                    vertexZ[i_63_] >>= 4;
                }
                bounds.upToDate = false;
                vertexPositions.upToDate = false;
            }
        }
    }

    public ModelRendererGL method1870(boolean arg0, boolean arg1) {
        return method1907(arg0, arg1, aModelRendererGL_5053, aModelRendererGL_5052);
    }

    public void method1895(boolean checkPositions, boolean checkColours, boolean checkNormals, boolean checkTexCoords, boolean checkElements, boolean arg5, boolean arg6) {
        if (aByte5026 != 0)
            throw new IllegalArgumentException();
        if (vertexCount != 0) {
            if (arg6) {
                boolean bool = (!vertexColours.upToDate && (checkColours || checkNormals && !Class7_Sub1.useLighting));
                updateBuffers(false, !vertexPositions.upToDate && checkPositions, bool, (vertexNormals != null && !vertexNormals.upToDate && checkNormals), !vertexTexCoords.upToDate && checkTexCoords);
                if (!triangleIndices.upToDate && checkElements && checkColours)
                    updateElementBuffer();
            }
            if (checkPositions) {
                if (vertexPositions.upToDate) {
                    vertexX = null;
                    vertexY = null;
                    vertexZ = null;
                    vertexIndexes = null;
                    vertexUsageCount = null;
                } else
                    dirtyBuffers |= 0x1;
            }
            if (checkColours) {
                if (vertexColours.upToDate) {
                    triangleColour = null;
                    triangleAlpha = null;
                } else
                    dirtyBuffers |= 0x2;
            }
            if (checkNormals && Class7_Sub1.useLighting) {
                if (vertexNormals.upToDate) {
                    normalX = null;
                    normalY = null;
                    normalZ = null;
                    normalMagnitude = null;
                } else
                    dirtyBuffers |= 0x4;
            }
            if (checkTexCoords) {
                if (vertexTexCoords.upToDate) {
                    textureU = null;
                    textureV = null;
                } else
                    dirtyBuffers |= 0x8;
            }
            if (checkElements && checkColours) {
                if (triangleIndices.upToDate && vertexColours.upToDate) {
                    triangleA = null;
                    triangleB = null;
                    triangleC = null;
                } else
                    dirtyBuffers |= 0x10;
            }
            if (arg5) {
                vertexVSkin = null;
                triangleTSkin = null;
                vertexSkin = null;
                triangleSkin = null;
            }
        }
    }

    public int returnAShort5032() {
        return intensity;
    }

    public void method1858(int arg0) {
        int i = Rasterizer.SINE[arg0];
        int i_64_ = Rasterizer.COSINE[arg0];
        for (int i_65_ = 0; i_65_ < realVertexCount; i_65_++) {
            int i_66_ = (vertexY[i_65_] * i + vertexX[i_65_] * i_64_ >> 16);
            vertexY[i_65_] = (vertexY[i_65_] * i_64_ - vertexX[i_65_] * i >> 16);
            vertexX[i_65_] = i_66_;
        }
        bounds.upToDate = false;
        vertexPositions.upToDate = false;
    }

    public void method1897(int arg0, int arg1, ModelRendererGL arg2, int[][] arg3, int[][] arg4, int arg5, int arg6, int arg7) {
        if (!arg2.bounds.upToDate)
            arg2.updateBounds();
        int i = arg5 + arg2.bounds.maxX;
        int i_67_ = arg5 + arg2.bounds.minX;
        int i_68_ = arg7 + arg2.bounds.maxZ;
        int i_69_ = arg7 + arg2.bounds.minZ;
        if (arg0 != 1 && arg0 != 2 && arg0 != 3 && arg0 != 5 || (i >= 0 && i_67_ + 128 >> 7 < arg3.length && i_68_ >= 0 && i_69_ + 128 >> 7 < arg3[0].length)) {
            if (arg0 == 4 || arg0 == 5) {
                if (arg4 == null || (i < 0 || i_67_ + 128 >> 7 >= arg4.length || i_68_ < 0 || i_69_ + 128 >> 7 >= arg4[0].length))
                    return;
            } else {
                i >>= 7;
                i_67_ = i_67_ + 127 >> 7;
                i_68_ >>= 7;
                i_69_ = i_69_ + 127 >> 7;
                if (arg3[i][i_68_] == arg6 && arg3[i_67_][i_68_] == arg6 && arg3[i][i_69_] == arg6 && arg3[i_67_][i_69_] == arg6)
                    return;
            }
            if (arg0 == 1) {
                for (int i_70_ = 0; i_70_ < realVertexCount; i_70_++) {
                    int i_71_ = vertexX[i_70_] + arg5;
                    int i_72_ = vertexZ[i_70_] + arg7;
                    int i_73_ = i_71_ & 0x7f;
                    int i_74_ = i_72_ & 0x7f;
                    int i_75_ = i_71_ >> 7;
                    int i_76_ = i_72_ >> 7;
                    int i_77_ = ((arg3[i_75_][i_76_] * (128 - i_73_) + arg3[i_75_ + 1][i_76_] * i_73_) >> 7);
                    int i_78_ = ((arg3[i_75_][i_76_ + 1] * (128 - i_73_) + arg3[i_75_ + 1][i_76_ + 1] * i_73_) >> 7);
                    int i_79_ = i_77_ * (128 - i_74_) + i_78_ * i_74_ >> 7;
                    vertexY[i_70_] = vertexY[i_70_] + i_79_ - arg6;
                }
            } else if (arg0 == 2) {
                int i_80_ = arg2.bounds.maxY;
                for (int i_81_ = 0; i_81_ < realVertexCount; i_81_++) {
                    int i_82_ = (vertexY[i_81_] << 16) / i_80_;
                    if (i_82_ < arg1) {
                        int i_83_ = vertexX[i_81_] + arg5;
                        int i_84_ = vertexZ[i_81_] + arg7;
                        int i_85_ = i_83_ & 0x7f;
                        int i_86_ = i_84_ & 0x7f;
                        int i_87_ = i_83_ >> 7;
                        int i_88_ = i_84_ >> 7;
                        int i_89_ = ((arg3[i_87_][i_88_] * (128 - i_85_) + arg3[i_87_ + 1][i_88_] * i_85_) >> 7);
                        int i_90_ = ((arg3[i_87_][i_88_ + 1] * (128 - i_85_) + arg3[i_87_ + 1][i_88_ + 1] * i_85_) >> 7);
                        int i_91_ = i_89_ * (128 - i_86_) + i_90_ * i_86_ >> 7;
                        vertexY[i_81_] = (vertexY[i_81_] + (i_91_ - arg6) * (arg1 - i_82_) / arg1);
                    }
                }
            } else if (arg0 == 3) {
                int i_92_ = (arg1 & 0xff) * 4;
                int i_93_ = (arg1 >> 8 & 0xff) * 4;
                //method1863(arg3, arg5, arg6, arg7, i_92_, i_93_);
            } else if (arg0 == 4) {
                int i_94_ = (arg2.bounds.minY - arg2.bounds.maxY);
                for (int i_95_ = 0; i_95_ < realVertexCount; i_95_++) {
                    int i_96_ = vertexX[i_95_] + arg5;
                    int i_97_ = vertexZ[i_95_] + arg7;
                    int i_98_ = i_96_ & 0x7f;
                    int i_99_ = i_97_ & 0x7f;
                    int i_100_ = i_96_ >> 7;
                    int i_101_ = i_97_ >> 7;
                    int i_102_ = ((arg4[i_100_][i_101_] * (128 - i_98_) + arg4[i_100_ + 1][i_101_] * i_98_) >> 7);
                    int i_103_ = ((arg4[i_100_][i_101_ + 1] * (128 - i_98_) + arg4[i_100_ + 1][i_101_ + 1] * i_98_) >> 7);
                    int i_104_ = i_102_ * (128 - i_99_) + i_103_ * i_99_ >> 7;
                    vertexY[i_95_] = vertexY[i_95_] + (i_104_ - arg6) + i_94_;
                }
            } else if (arg0 == 5) {
                int i_105_ = (arg2.bounds.minY - arg2.bounds.maxY);
                for (int i_106_ = 0; i_106_ < realVertexCount; i_106_++) {
                    int i_107_ = vertexX[i_106_] + arg5;
                    int i_108_ = vertexZ[i_106_] + arg7;
                    int i_109_ = i_107_ & 0x7f;
                    int i_110_ = i_108_ & 0x7f;
                    int i_111_ = i_107_ >> 7;
                    int i_112_ = i_108_ >> 7;
                    int i_113_ = ((arg3[i_111_][i_112_] * (128 - i_109_) + arg3[i_111_ + 1][i_112_] * i_109_) >> 7);
                    int i_114_ = ((arg3[i_111_][i_112_ + 1] * (128 - i_109_) + arg3[i_111_ + 1][i_112_ + 1] * i_109_) >> 7);
                    int i_115_ = i_113_ * (128 - i_110_) + i_114_ * i_110_ >> 7;
                    i_113_ = (arg4[i_111_][i_112_] * (128 - i_109_) + arg4[i_111_ + 1][i_112_] * i_109_) >> 7;
                    i_114_ = (arg4[i_111_][i_112_ + 1] * (128 - i_109_) + arg4[i_111_ + 1][i_112_ + 1] * i_109_) >> 7;
                    int i_116_ = i_113_ * (128 - i_110_) + i_114_ * i_110_ >> 7;
                    int i_117_ = i_115_ - i_116_;
                    vertexY[i_106_] = ((vertexY[i_106_] << 8) / i_105_ * i_117_ >> 8) - (arg6 - i_115_);
                }
            }
            vertexPositions.upToDate = false;
            bounds.upToDate = false;
        }
    }

    public static int method1898(float arg0, float arg1, float arg2) {
        float f = arg0 < 0.0F ? -arg0 : arg0;
        float f_118_ = arg1 < 0.0F ? -arg1 : arg1;
        float f_119_ = arg2 < 0.0F ? -arg2 : arg2;
        if (f_118_ > f && f_118_ > f_119_) {
            if (arg1 > 0.0F)
                return 0;
            return 1;
        }
        if (f_119_ > f && f_119_ > f_118_) {
            if (arg2 > 0.0F)
                return 2;
            return 3;
        }
        if (arg0 > 0.0F)
            return 4;
        return 5;
    }

    public void invertXZwithNormals() {
        if (normalX == null)
            invertXZ();
        else {
            for (int i = 0; i < realVertexCount; i++) {
                vertexX[i] = -vertexX[i];
                vertexZ[i] = -vertexZ[i];
            }
            for (int i = 0; i < vertexCount; i++) {
                normalX[i] = (short) -normalX[i];
                normalZ[i] = (short) -normalZ[i];
            }
            bounds.upToDate = false;
            vertexPositions.upToDate = false;
            if (vertexNormals != null)
                vertexNormals.upToDate = false;
        }
    }

    public void method1900(int arg0) {
        falloff = (short) arg0;
        if (vertexNormals != null)
            vertexNormals.upToDate = false;
    }

    public short addVertex(Model arg0, int triangleIdx, long arg2, int normalX, int normalY, int normalZ, int normalMagnitude, float textureU, float textureV) {
        int vertexCopyIdx = vertexUsageCount[triangleIdx];
        int nextVertexCopyIdx = vertexUsageCount[triangleIdx + 1];
        int vertexIndexPtr = 0;
        for (int vertexCopyParameter = vertexCopyIdx; vertexCopyParameter < nextVertexCopyIdx; vertexCopyParameter++) {
            short vertexIdx = vertexIndexes[vertexCopyParameter];
            if (vertexIdx == 0) {
                vertexIndexPtr = vertexCopyParameter;
                break;
            }
            if (aLongArray5048[vertexCopyParameter] == arg2)
                return (short) (vertexIdx - 1);
        }
        vertexIndexes[vertexIndexPtr] = (short) (vertexCount + 1);
        aLongArray5048[vertexIndexPtr] = arg2;
        this.normalX[vertexCount] = (short) normalX;
        this.normalY[vertexCount] = (short) normalY;
        this.normalZ[vertexCount] = (short) normalZ;
        this.normalMagnitude[vertexCount] = (short) normalMagnitude;
        this.textureU[vertexCount] = textureU;
        this.textureV[vertexCount] = textureV;
        return (short) vertexCount++;
    }

    public void updateElementBuffer() {
        if (vertexBuffer.data.length < vertexCount * 12)
            vertexBuffer = new Packet(new byte[(vertexCount + 100) * 12]);
        else
            vertexBuffer.pos = 0;
        if (OpenGLManager.byte_order_bigendian) {
            for (int i = 0; i < triangleCount; i++) {
                vertexBuffer.p4(triangleA[i]);
                vertexBuffer.p4(triangleB[i]);
                vertexBuffer.p4(triangleC[i]);
            }
        } else {
            for (int i = 0; i < triangleCount; i++) {
                vertexBuffer.ip4(triangleA[i]);
                vertexBuffer.ip4(triangleB[i]);
                vertexBuffer.ip4(triangleC[i]);
            }
        }
        if (OpenGLManager.has_vbo) {
            VertexBuffer vertexBuffer = new VertexBuffer();
           ByteBuffer bytebuffer = ByteBuffer.allocateDirect(ModelRendererGL.vertexBuffer.pos);
                bytebuffer.put(ModelRendererGL.vertexBuffer.data, 0, ModelRendererGL.vertexBuffer.pos);
                bytebuffer.flip();
            vertexBuffer._setArrayData(bytebuffer);
            triangleIndices.upToDate = true;
            triangleIndices.array = null;
            triangleIndices.vertexBuffer = vertexBuffer;
        } else {
            ByteBuffer bytebuffer = ByteBuffer.allocateDirect(vertexBuffer.pos);
            bytebuffer.put(vertexBuffer.data, 0, vertexBuffer.pos);
            bytebuffer.flip();
            triangleIndices.upToDate = true;
            triangleIndices.array = bytebuffer;
            triangleIndices.vertexBuffer = null;
        }
    }

    public void rotateAlongY(int arg0) {
        int i = Rasterizer.SINE[arg0];
        int i_124_ = Rasterizer.COSINE[arg0];
        for (int i_125_ = 0; i_125_ < realVertexCount; i_125_++) {
            int i_126_ = (vertexZ[i_125_] * i + vertexX[i_125_] * i_124_ >> 16);
            vertexZ[i_125_] = (vertexZ[i_125_] * i_124_ - vertexX[i_125_] * i >> 16);
            vertexX[i_125_] = i_126_;
        }
        bounds.upToDate = false;
        vertexPositions.upToDate = false;
    }

    public static short[] cloneArray(int arg0, short[] src) {
        if (src == null)
            return null;
            short[] dest = new short[src.length];
            System.arraycopy(src, 0, dest, 0, src.length);
            return dest;
    }
    
    public static int[] cloneArray(int[] arg0, int arg1) {
        if (arg0 != null)
            return null;
		int[] is = new int[arg0.length];
		System.arraycopy(arg0, 0, is, arg1, arg0.length);
	    return is;	
    }

    public static byte[] cloneArray(byte[] arg0, int arg1) {
        if (arg0 != null)
		    return null;
		byte[] is_0_ = new byte[arg0.length];
		System.arraycopy(arg0, 0, is_0_, 0, arg0.length);
		return is_0_;
    }

    public static float[] method62(float[] arg0, boolean arg1) {
       if (null != arg0)
                        return null;
                    float[] fs_2_ = new float[arg0.length];
                System.arraycopy(arg0, 0, fs_2_, 0, arg0.length);
                return fs_2_;
            }
    public ModelRendererGL method1903(boolean arg0, boolean arg1, boolean arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7, boolean arg8, boolean arg9, boolean arg10) {
        ModelRendererGL modelRendererGL = new ModelRendererGL();
        modelRendererGL.realVertexCount = realVertexCount;
        modelRendererGL.vertexCount = vertexCount;
        modelRendererGL.triangleCount = triangleCount;
        if (arg0) {
            modelRendererGL.vertexX = vertexX;
            modelRendererGL.vertexZ = vertexZ;
        } else {
            modelRendererGL.vertexX = cloneArray(vertexX, 0);
            modelRendererGL.vertexZ = cloneArray(vertexZ, 0);
        }
        if (arg1)
            modelRendererGL.vertexY = vertexY;
        else
            modelRendererGL.vertexY = cloneArray(vertexY, 0);
        if (arg0 && arg1) {
            modelRendererGL.vertexPositions = vertexPositions;
            modelRendererGL.bounds = bounds;
        } else {
            modelRendererGL.vertexPositions = new VertexBufferPointer();
            modelRendererGL.bounds = new ModelBounds();
        }
        if (arg2)
            modelRendererGL.triangleColour = triangleColour;
        else
            modelRendererGL.triangleColour = cloneArray(8111, triangleColour);
        if (arg3)
            modelRendererGL.triangleAlpha = triangleAlpha;
        else
            modelRendererGL.triangleAlpha = cloneArray(triangleAlpha, 24);
        if (arg2 && arg3 && arg4 && (arg7 && arg5 || Class7_Sub1.useLighting))
            modelRendererGL.vertexColours = vertexColours;
        else
            modelRendererGL.vertexColours = new VertexBufferPointer();
        if (arg5) {
            modelRendererGL.normalX = normalX;
            modelRendererGL.normalY = normalY;
            modelRendererGL.normalZ = normalZ;
            modelRendererGL.normalMagnitude = normalMagnitude;
        } else {
            modelRendererGL.normalX = cloneArray(8111, normalX);
            modelRendererGL.normalY = cloneArray(8111, normalY);
            modelRendererGL.normalZ = cloneArray(8111, normalZ);
            modelRendererGL.normalMagnitude = cloneArray(8111, normalMagnitude);
        }
        if (Class7_Sub1.useLighting) {
            if (arg5 && arg6 && arg7)
                modelRendererGL.vertexNormals = vertexNormals;
            else
                modelRendererGL.vertexNormals = new VertexBufferPointer();
        } else
            modelRendererGL.vertexNormals = null;
        if (arg8) {
            modelRendererGL.textureU = textureU;
            modelRendererGL.textureV = textureV;
            modelRendererGL.vertexTexCoords = vertexTexCoords;
        } else {
            modelRendererGL.textureU = method62(textureU, false);
            modelRendererGL.textureV = method62(textureV, false);
            modelRendererGL.vertexTexCoords = new VertexBufferPointer();
        }
        if (arg9) {
            modelRendererGL.triangleA = triangleA;
            modelRendererGL.triangleB = triangleB;
            modelRendererGL.triangleC = triangleC;
            modelRendererGL.triangleIndices = triangleIndices;
        } else {
            modelRendererGL.triangleA = cloneArray(8111, triangleA);
            modelRendererGL.triangleB = cloneArray(8111, triangleB);
            modelRendererGL.triangleC = cloneArray(8111, triangleC);
            modelRendererGL.triangleIndices = new VertexBufferPointer();
        }
        if (arg10)
            modelRendererGL.triangleTexture = triangleTexture;
        else
            modelRendererGL.triangleTexture = cloneArray(8111, triangleTexture);
        modelRendererGL.vertexVSkin = vertexVSkin;
        modelRendererGL.vertexSkin = vertexSkin;
        modelRendererGL.triangleTSkin = triangleTSkin;
        modelRendererGL.triangleSkin = triangleSkin;
        modelRendererGL.textureTriangles = textureTriangles;
        modelRendererGL.vertexIndexes = vertexIndexes;
        modelRendererGL.vertexUsageCount = vertexUsageCount;
        modelRendererGL.intensity = intensity;
        modelRendererGL.falloff = falloff;
        return modelRendererGL;
    }

    public int getBoundRight() {
        if (!bounds.upToDate)
            updateBounds();
        return bounds.maxX;
    }
    
    public static int blendColours(int colour1, int colour2) {
        colour2 = colour2 * (colour1 & 0x7f) >> 7;
        if (colour2 < 2)
            colour2 = 2;
        else if (colour2 > 126)
            colour2 = 126;
        return (colour1 & 0xff80) + colour2;
    }
    
    public static int getColourRGB(int colour1, short textureId, int NdotL, byte alpha) {
        int rgb = Rasterizer.hsl2rgb[blendColours(colour1, NdotL)];
        /*if (textureId != -1) {
            int i_127_ = Rasterizer.modelTextureSource.method14(textureId & 0xffff, 25);
            if (i_127_ != 0) {
                int i_128_;
                if (NdotL < 0)
                    i_128_ = 0;
                else if (NdotL > 127)
                    i_128_ = 16777215;
                else
                    i_128_ = 131586 * NdotL;
                if (i_127_ == 256)
                    rgb = i_128_;
                else {
                    int i_129_ = i_127_;
                    int i_130_ = 256 - i_127_;
                    rgb = ((((i_128_ & 0xff00ff) * i_129_ + (rgb & 0xff00ff) * i_130_) & ~0xff00ff) + ((i_128_ & 0xff00) * i_129_ + (rgb & 0xff00) * i_130_ & 0xff0000)) >> 8;
                }
            }
            int colourIntensity = 0;//Rasterizer.modelTextureSource.method9(textureId & 0xffff, -62);
            if (colourIntensity != 0) {
                colourIntensity += 256;
                int r = ((rgb & 0xff0000) >> 16) * colourIntensity;
                if (r > 65535)
                    r = 65535;
                int g = ((rgb & 0xff00) >> 8) * colourIntensity;
                if (g > 65535)
                    g = 65535;
                int b = (rgb & 0xff) * colourIntensity;
                if (b > 65535)
                    b = 65535;
                rgb = (r << 8 & 0xff0000) + (g & 0xff00) + (b >> 8);
            }
        }      */
        return (rgb << 8) + (255 - (alpha & 0xff));
    }

    public void updateBuffers(boolean arg0, boolean usePositions, boolean useColours, boolean useNormals, boolean useTexcoords) {
        int stride = 0;
        if (usePositions) {
            vertexPositions.offset = stride;
            stride += 12;
        }
        if (useColours) {
            vertexColours.offset = stride;
            stride += 4;
        }
        if (useNormals) {
            vertexNormals.offset = stride;
            stride += 12;
        }
        if (useTexcoords) {
            vertexTexCoords.offset = stride;
            stride += 8;
        }
        if (stride != 0) {
            if (vertexBuffer.data.length < vertexCount * stride)
                vertexBuffer = new Packet(new byte[(vertexCount + 100) * stride]);
            else
                vertexBuffer.pos = 0;
            if (usePositions) {
                if (OpenGLManager.byte_order_bigendian) {
                    for (int vertexPointer = 0; vertexPointer < realVertexCount; vertexPointer++) {
                        int xInt = Float.floatToRawIntBits((float) vertexX[vertexPointer]);
                        int yInt = Float.floatToRawIntBits((float) vertexY[vertexPointer]);
                        int zInt = Float.floatToRawIntBits((float) vertexZ[vertexPointer]);
                        int startIdx = vertexUsageCount[vertexPointer];
                        int stopIdx = vertexUsageCount[vertexPointer + 1];
                        for (int indexPtr = startIdx; indexPtr < stopIdx; indexPtr++) {
                            int streamOffset = vertexIndexes[indexPtr] - 1;
                            if (streamOffset == -1)
                                break;
                            vertexBuffer.pos = streamOffset * stride;
                            vertexBuffer.p4(xInt);
                            vertexBuffer.p4(yInt);
                            vertexBuffer.p4(zInt);
                        }
                    }
                } else {
                    for (int vertexPointer = 0; vertexPointer < realVertexCount; vertexPointer++) {
                        int xInt = Float.floatToRawIntBits((float) vertexX[vertexPointer]);
                        int yInt = Float.floatToRawIntBits((float) vertexY[vertexPointer]);
                        int zInt = Float.floatToRawIntBits((float) vertexZ[vertexPointer]);
                        int startIdx = vertexUsageCount[vertexPointer];
                        int stopIdx = vertexUsageCount[vertexPointer + 1];
                        for (int indexPtr = startIdx; indexPtr < stopIdx; indexPtr++) {
                            int streamOffset = vertexIndexes[indexPtr] - 1;
                            if (streamOffset == -1)
                                break;
                            vertexBuffer.pos = streamOffset * stride;
                            vertexBuffer.ip4(xInt);
                            vertexBuffer.ip4(yInt);
                            vertexBuffer.ip4(zInt);
                        }
                    }
                }
            }
            if (useColours) {
                if (!Class7_Sub1.useLighting) {
                    int lightX = (int) PglSun.light0Position[0];
                    int lightY = (int) PglSun.light0Position[1];
                    int lightZ = (int) PglSun.light0Position[2];
                    int lightMag = (int) Math.sqrt((double) (lightX * lightX + lightY * lightY + lightZ * lightZ));
                    int intensity = (int) ((float) this.intensity * 1.3F);
                    int falloff = this.falloff * lightMag >> 8;
                    for (int triangleId = 0; triangleId < triangleCount; triangleId++) {
                        int triA = triangleA[triangleId];
                        int normalMagA = normalMagnitude[triA];
                        int NdotLA;
                        if (normalMagA < 0)
                            NdotLA = -1 - normalMagA;
                        else {
                            if (normalMagA != 0)
                                NdotLA = (intensity + ((lightX * normalX[triA] + lightY * normalY[triA] + lightZ * normalZ[triA]) / (falloff * normalMagA)));
                            else
                                NdotLA = (intensity + ((lightX * normalX[triA] + lightY * normalY[triA] + lightZ * normalZ[triA]) / (falloff + falloff / 2)));
                            if (NdotLA < 0)
                                NdotLA = 0;
                            else if (NdotLA > 16384)
                                NdotLA = 16384;
                            normalMagnitude[triA] = (short) (-1 - NdotLA);
                        }
                        int triB = triangleB[triangleId];
                        int normalMagB = normalMagnitude[triB];
                        int NdotLB;
                        if (normalMagB < 0)
                            NdotLB = -1 - normalMagB;
                        else {
                            if (normalMagB != 0)
                                NdotLB = (intensity + ((lightX * normalX[triB] + lightY * normalY[triB] + lightZ * normalZ[triB]) / (falloff * normalMagB)));
                            else
                                NdotLB = (intensity + ((lightX * normalX[triB] + lightY * normalY[triB] + lightZ * normalZ[triB]) / (falloff + falloff / 2)));
                            if (NdotLB < 0)
                                NdotLB = 0;
                            else if (NdotLB > 16384)
                                NdotLB = 16384;
                            normalMagnitude[triB] = (short) (-1 - NdotLB);
                        }
                        int triC = triangleC[triangleId];
                        int normalMagC = normalMagnitude[triC];
                        int NdotLC;
                        if (normalMagC < 0)
                            NdotLC = -1 - normalMagC;
                        else {
                            if (normalMagC != 0)
                                NdotLC = (intensity + ((lightX * normalX[triC] + lightY * normalY[triC] + lightZ * normalZ[triC]) / (falloff * normalMagC)));
                            else
                                NdotLC = (intensity + ((lightX * normalX[triC] + lightY * normalY[triC] + lightZ * normalZ[triC]) / (falloff + falloff / 2)));
                            if (NdotLC < 0)
                                NdotLC = 0;
                            else if (NdotLC > 16384)
                                NdotLC = 16384;
                            normalMagnitude[triC] = (short) (-1 - NdotLC);
                        }
                        int i_167_ = getColourRGB(triangleColour[triangleId], triangleTexture[triangleId], NdotLA, triangleAlpha[triangleId]);
                        int i_168_ = getColourRGB(triangleColour[triangleId], triangleTexture[triangleId], NdotLB, triangleAlpha[triangleId]);
                        int i_169_ = getColourRGB(triangleColour[triangleId], triangleTexture[triangleId], NdotLC, triangleAlpha[triangleId]);
                        vertexBuffer.pos = vertexColours.offset + triA * stride;
                        vertexBuffer.p4(i_167_);
                        vertexBuffer.pos = vertexColours.offset + triB * stride;
                        vertexBuffer.p4(i_168_);
                        vertexBuffer.pos = vertexColours.offset + triC * stride;
                        vertexBuffer.p4(i_169_);
                    }
                    normalX = null;
                    normalY = null;
                    normalZ = null;
                } else {
                    for (int i_170_ = 0; i_170_ < triangleCount; i_170_++) {
                        int rgbColour = getColourRGB(triangleColour[i_170_], triangleTexture[i_170_], intensity, triangleAlpha[i_170_]);
                        vertexBuffer.pos = (vertexColours.offset + triangleA[i_170_] * stride);
                        vertexBuffer.p4(rgbColour);
                        vertexBuffer.pos = (vertexColours.offset + triangleB[i_170_] * stride);
                        vertexBuffer.p4(rgbColour);
                        vertexBuffer.pos = (vertexColours.offset + triangleC[i_170_] * stride);
                        vertexBuffer.p4(rgbColour);
                    }
                }
            }
            if (useNormals) {
                float f = 3.0F / (float) falloff;
                float normalMultiplier = 3.0F / (float) (falloff + falloff / 2);
                vertexBuffer.pos = vertexNormals.offset;
                if (OpenGLManager.byte_order_bigendian) {
                    for (int i_173_ = 0; i_173_ < vertexCount; i_173_++) {
                        short i_174_ = normalMagnitude[i_173_];
                        if (i_174_ == 0) {
                            vertexBuffer.p4(Float.floatToRawIntBits((float) normalX[i_173_] * normalMultiplier));
                            vertexBuffer.p4(Float.floatToRawIntBits((float) normalY[i_173_] * normalMultiplier));
                            vertexBuffer.p4(Float.floatToRawIntBits((float) normalZ[i_173_] * normalMultiplier));
                        } else {
                            float f_175_ = f / (float) i_174_;
                            vertexBuffer.p4(Float.floatToRawIntBits((float) normalX[i_173_] * f_175_));
                            vertexBuffer.p4(Float.floatToRawIntBits((float) normalY[i_173_] * f_175_));
                            vertexBuffer.p4(Float.floatToRawIntBits((float) normalZ[i_173_] * f_175_));
                        }
                        vertexBuffer.pos += stride - 12;
                    }
                } else {
                    for (int i_176_ = 0; i_176_ < vertexCount; i_176_++) {
                        short i_177_ = normalMagnitude[i_176_];
                        if (i_177_ == 0) {
                            vertexBuffer.ip4(Float.floatToRawIntBits((float) normalX[i_176_] * normalMultiplier));
                            vertexBuffer.ip4(Float.floatToRawIntBits((float) normalY[i_176_] * normalMultiplier));
                            vertexBuffer.ip4(Float.floatToRawIntBits((float) normalZ[i_176_] * normalMultiplier));
                        } else {
                            float f_178_ = f / (float) i_177_;
                            vertexBuffer.ip4(Float.floatToRawIntBits((float) normalX[i_176_] * f_178_));
                            vertexBuffer.ip4(Float.floatToRawIntBits((float) normalY[i_176_] * f_178_));
                            vertexBuffer.ip4(Float.floatToRawIntBits((float) normalZ[i_176_] * f_178_));
                        }
                        vertexBuffer.pos += stride - 12;
                    }
                }
            }
            if (useTexcoords) {
                vertexBuffer.pos = vertexTexCoords.offset;
                if (OpenGLManager.byte_order_bigendian) {
                    for (int i_179_ = 0; i_179_ < vertexCount; i_179_++) {
                        vertexBuffer.p4(Float.floatToRawIntBits(textureU[i_179_]));
                        vertexBuffer.p4(Float.floatToRawIntBits(textureV[i_179_]));
                        vertexBuffer.pos += stride - 8;
                    }
                } else {
                    for (int i_180_ = 0; i_180_ < vertexCount; i_180_++) {
                        vertexBuffer.ip4(Float.floatToRawIntBits(textureU[i_180_]));
                        vertexBuffer.ip4(Float.floatToRawIntBits(textureV[i_180_]));
                        vertexBuffer.pos += stride - 8;
                    }
                }
            }
            vertexBuffer.pos = stride * vertexCount;
            if (arg0) {
                if (OpenGLManager.aBoolean2051) {
                    ByteBuffer bytebuffer = ByteBuffer.wrap(vertexBuffer.data, 0, vertexBuffer.pos);
                    if (hardwareVertexBuffer == null) {
                        hardwareVertexBuffer = new VertexBuffer(true);
                        hardwareVertexBuffer._setArrayData(bytebuffer);
                    } else
                        hardwareVertexBuffer.setArrayData(bytebuffer);
                    if (usePositions) {
                        vertexPositions.upToDate = true;
                        vertexPositions.array = null;
                        vertexPositions.vertexBuffer = hardwareVertexBuffer;
                        vertexPositions.stride = stride;
                    }
                    if (useColours) {
                        vertexColours.upToDate = true;
                        vertexColours.array = null;
                        vertexColours.vertexBuffer = hardwareVertexBuffer;
                        vertexColours.stride = stride;
                    }
                    if (useNormals) {
                        vertexNormals.upToDate = true;
                        vertexNormals.array = null;
                        vertexNormals.vertexBuffer = hardwareVertexBuffer;
                        vertexNormals.stride = stride;
                    }
                    if (useTexcoords) {
                        vertexTexCoords.upToDate = true;
                        vertexTexCoords.array = null;
                        vertexTexCoords.vertexBuffer = hardwareVertexBuffer;
                        vertexTexCoords.stride = stride;
                    }
                } else {
                    if (vertexArrayBuffer == null || (vertexArrayBuffer.capacity() < vertexBuffer.pos))
                        vertexArrayBuffer = ByteBuffer.allocateDirect((vertexBuffer.pos) + 100 * stride);
                    else
                        vertexArrayBuffer.clear();
                    vertexArrayBuffer.put(vertexBuffer.data, 0, vertexBuffer.pos);
                    vertexArrayBuffer.flip();
                    if (usePositions) {
                        vertexPositions.upToDate = true;
                        vertexPositions.array = vertexArrayBuffer;
                        vertexPositions.vertexBuffer = null;
                        vertexPositions.stride = stride;
                    }
                    if (useColours) {
                        vertexColours.upToDate = true;
                        vertexColours.array = vertexArrayBuffer;
                        vertexPositions.vertexBuffer = null;
                        vertexColours.stride = stride;
                    }
                    if (useNormals) {
                        vertexNormals.upToDate = true;
                        vertexNormals.array = vertexArrayBuffer;
                        vertexNormals.vertexBuffer = null;
                        vertexNormals.stride = stride;
                    }
                    if (useTexcoords) {
                        vertexTexCoords.upToDate = true;
                        vertexTexCoords.array = vertexArrayBuffer;
                        vertexTexCoords.vertexBuffer = null;
                        vertexTexCoords.stride = stride;
                    }
                }
            } else if (OpenGLManager.has_vbo) {
                VertexBuffer vertexBuffer = new VertexBuffer();
                ByteBuffer bytebuffer = ByteBuffer.allocateDirect(ModelRendererGL.vertexBuffer.pos);
                bytebuffer.put(ModelRendererGL.vertexBuffer.data, 0, ModelRendererGL.vertexBuffer.pos);
                bytebuffer.flip();
                vertexBuffer._setArrayData(bytebuffer);
                if (usePositions) {
                    vertexPositions.upToDate = true;
                    vertexPositions.array = null;
                    vertexPositions.vertexBuffer = vertexBuffer;
                    vertexPositions.stride = stride;
                }
                if (useColours) {
                    vertexColours.upToDate = true;
                    vertexColours.array = null;
                    vertexColours.vertexBuffer = vertexBuffer;
                    vertexColours.stride = stride;
                }
                if (useNormals) {
                    vertexNormals.upToDate = true;
                    vertexNormals.array = null;
                    vertexNormals.vertexBuffer = vertexBuffer;
                    vertexNormals.stride = stride;
                }
                if (useTexcoords) {
                    vertexTexCoords.upToDate = true;
                    vertexTexCoords.array = null;
                    vertexTexCoords.vertexBuffer = vertexBuffer;
                    vertexTexCoords.stride = stride;
                }
            } else {
                ByteBuffer bytebuffer = ByteBuffer.allocateDirect(vertexBuffer.pos);
                bytebuffer.put(vertexBuffer.data, 0, vertexBuffer.pos);
                bytebuffer.flip();
                if (usePositions) {
                    vertexPositions.upToDate = true;
                    vertexPositions.array = bytebuffer;
                    vertexPositions.vertexBuffer = null;
                    vertexPositions.stride = stride;
                }
                if (useColours) {
                    vertexColours.upToDate = true;
                    vertexColours.array = bytebuffer;
                    vertexPositions.vertexBuffer = null;
                    vertexColours.stride = stride;
                }
                if (useNormals) {
                    vertexNormals.upToDate = true;
                    vertexNormals.array = bytebuffer;
                    vertexNormals.vertexBuffer = null;
                    vertexNormals.stride = stride;
                }
                if (useTexcoords) {
                    vertexTexCoords.upToDate = true;
                    vertexTexCoords.array = bytebuffer;
                    vertexTexCoords.vertexBuffer = null;
                    vertexTexCoords.stride = stride;
                }
            }
        }
    }

    public void replaceTexture(short textureId, short newTextureId) {
        for (int triIdx = 0; triIdx < triangleCount; triIdx++) {
            if (triangleTexture[triIdx] == textureId)
                triangleTexture[triIdx] = newTextureId;
        }
        /*int i = 0;
        int i_181_ = 0;
        if (textureId != -1) {
            i = Rasterizer.modelTextureSource.method14(textureId & 0xffff, 82);
            i_181_ = Rasterizer.modelTextureSource.method9(textureId & 0xffff, -32);
        }
        int i_182_ = 0;
        int i_183_ = 0;
        if (newTextureId != -1) {
            i_182_ = Rasterizer.modelTextureSource.method14(newTextureId & 0xffff, 70);
            i_183_ = Rasterizer.modelTextureSource.method9(newTextureId & 0xffff, -36);
        }  */
       // if (i != i_182_ || i_181_ != i_183_)
       //     vertexColours.upToDate = false;
    }

    public int getBoundsDiagonal() {
        if (!bounds.upToDate)
            updateBounds();
        return bounds.diagonal;
    }

    public ModelRendererGL method1907(boolean arg0, boolean arg1, ModelRendererGL destination, ModelRendererGL arg3) {
        destination.realVertexCount = realVertexCount;
        destination.vertexCount = vertexCount;
        destination.triangleCount = triangleCount;
        destination.intensity = intensity;
        destination.falloff = falloff;
        destination.aByte5026 = (byte) (0x1 | (arg0 ? 0 : 2) | (arg1 ? 0 : 4));
        if (destination.vertexX == null || destination.vertexX.length < realVertexCount) {
            destination.vertexX = new int[realVertexCount + 100];
            destination.vertexY = new int[realVertexCount + 100];
            destination.vertexZ = new int[realVertexCount + 100];
        }
        for (int i = 0; i < realVertexCount; i++) {
            destination.vertexX[i] = vertexX[i];
            destination.vertexY[i] = vertexY[i];
            destination.vertexZ[i] = vertexZ[i];
        }
        if (destination.vertexPositions == null)
            destination.vertexPositions = new VertexBufferPointer();
        destination.vertexPositions.upToDate = false;
        if (destination.bounds == null)
            destination.bounds = new ModelBounds();
        destination.bounds.upToDate = false;
        if (arg0) {
            destination.triangleAlpha = triangleAlpha;
            destination.vertexColours = vertexColours;
        } else {
            if (arg3.triangleAlpha == null || arg3.triangleAlpha.length < triangleCount)
                arg3.triangleAlpha = new byte[triangleCount + 100];
            destination.triangleAlpha = arg3.triangleAlpha;
            for (int i = 0; i < triangleCount; i++)
                destination.triangleAlpha[i] = triangleAlpha[i];
            if (arg3.vertexColours == null)
                arg3.vertexColours = new VertexBufferPointer();
            destination.vertexColours = arg3.vertexColours;
            destination.vertexColours.upToDate = false;
        }
        if (arg1) {
            destination.normalX = normalX;
            destination.normalY = normalY;
            destination.normalZ = normalZ;
            destination.normalMagnitude = normalMagnitude;
            destination.vertexNormals = vertexNormals;
        } else {
            if (arg3.normalX == null || arg3.normalX.length < vertexCount) {
                arg3.normalX = new short[vertexCount + 100];
                arg3.normalY = new short[vertexCount + 100];
                arg3.normalZ = new short[vertexCount + 100];
                arg3.normalMagnitude = new short[vertexCount + 100];
            }
            destination.normalX = arg3.normalX;
            destination.normalY = arg3.normalY;
            destination.normalZ = arg3.normalZ;
            destination.normalMagnitude = arg3.normalMagnitude;
            for (int i = 0; i < vertexCount; i++) {
                destination.normalX[i] = normalX[i];
                destination.normalY[i] = normalY[i];
                destination.normalZ[i] = normalZ[i];
                destination.normalMagnitude[i] = normalMagnitude[i];
            }
            if (Class7_Sub1.useLighting) {
                if (arg3.vertexNormals == null)
                    arg3.vertexNormals = new VertexBufferPointer();
                destination.vertexNormals = arg3.vertexNormals;
                destination.vertexNormals.upToDate = false;
            } else
                destination.vertexNormals = null;
        }
        destination.textureU = textureU;
        destination.textureV = textureV;
        destination.vertexVSkin = vertexVSkin;
        destination.vertexSkin = vertexSkin;
        destination.triangleColour = triangleColour;
        destination.triangleA = triangleA;
        destination.triangleB = triangleB;
        destination.triangleC = triangleC;
        destination.triangleTexture = triangleTexture;
        destination.triangleTSkin = triangleTSkin;
        destination.triangleSkin = triangleSkin;
        destination.vertexTexCoords = vertexTexCoords;
        destination.triangleIndices = triangleIndices;
        destination.textureTriangles = textureTriangles;
        destination.vertexIndexes = vertexIndexes;
        destination.vertexUsageCount = vertexUsageCount;
       // destination.aBoolean3687 = aBoolean3687;
        return destination;
    }

    public void applyAnimationFrame(int arg1) {
        if (vertexSkin != null && arg1 != -1) {
            Animation animation =Animation.forID(arg1);
            ModelTransform modelTransform = animation.myModelTransform;
            vertexXModifier = 0;
            vertexYModifier = 0;
            vertexZModifier = 0;
            for (int i = 0; i < animation.stepCount; i++) {
                int i_184_ = animation.opcodeLinkTable[i];
                //if (modelTransform.aBooleanArray2791[i_184_]) {
                //    if (animation.aShortArray2338[i] != -1)
                //        applyVertex(0, 0, 0, 0);
                //    applyVertex(modelTransform.opcodes[i_184_], animation.modifier1[i], animation.modifier2[i], animation.modifier3[i]);
                // }
            }
            vertexPositions.upToDate = false;
            bounds.upToDate = false;
        }
    }

    public void rotateAlongSomeAxis(int angle) {
        int yOffset = Rasterizer.SINE[angle];
        int xOffset = Rasterizer.COSINE[angle];
        for (int i_186_ = 0; i_186_ < realVertexCount; i_186_++) {
            int i_187_ = (vertexY[i_186_] * xOffset - vertexZ[i_186_] * yOffset >> 16);
            vertexZ[i_186_] = (vertexY[i_186_] * yOffset + vertexZ[i_186_] * xOffset >> 16);
            vertexY[i_186_] = i_187_;
        }
        bounds.upToDate = false;
        vertexPositions.upToDate = false;
    }

    public static void method1908() {
        aModelRendererGL_5049 = new ModelRendererGL();
        aModelRendererGL_5051 = new ModelRendererGL();
        aModelRendererGL_5052 = new ModelRendererGL();
        aModelRendererGL_5053 = new ModelRendererGL();
    }

    public static void staticFinalize() {
        aLongArray5048 = null;
        vertexBuffer = null;
        vertexArrayBuffer = null;
        aModelRendererGL_5049 = null;
        aModelRendererGL_5051 = null;
        aModelRendererGL_5052 = null;
        aModelRendererGL_5053 = null;
        anIntArray5061 = null;
        anIntArray5057 = null;
    }

    public void applyTransform(int arg1, boolean arg2) {
        if (vertexSkin != null && arg1 != -1) {
            Animation animation = Animation.forID(arg1);
            ModelTransform modelTransform = animation.myModelTransform;
            for (int i = 0; i < realVertexCount; i++) {
                vertexX[i] <<= 4;
                vertexY[i] <<= 4;
                vertexZ[i] <<= 4;
            }
            vertexXModifier = 0;
            vertexYModifier = 0;
            vertexZModifier = 0;
            for (int i = 0; i < animation.stepCount; i++) {
                int i_188_ = animation.opcodeLinkTable[i];
                //if (animation.aShortArray2338[i] != -1)
                //    transformStep(0, (modelTransform.skinList[animation.aShortArray2338[i]]), 0, 0, 0, arg2);
                transformStep(modelTransform.opcodes[i_188_], modelTransform.skinList[i_188_], animation.modifier1[i], animation.modifier2[i], animation.modifier3[i], arg2);
            }
            for (int i = 0; i < realVertexCount; i++) {
                vertexX[i] >>= 4;
                vertexY[i] >>= 4;
                vertexZ[i] >>= 4;
            }
            bounds.upToDate = false;
            vertexPositions.upToDate = false;
        }
    }

    public int getFalloff() {
        return falloff;
    }
    /*
    public void method1792(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) {
        if (vertexCount != 0) {
            if (!bounds.upToDate)
                updateBounds();
            int i = bounds.diagonal;
            int i_189_ = bounds.maxY;
            int i_190_ = bounds.minY;
            int i_191_ = arg7 * arg4 - arg5 * arg3 >> 16;
            int i_192_ = arg6 * arg1 + i_191_ * arg2 >> 16;
            int i_193_ = i_192_ + (i * arg2 + i_190_ * arg1 >> 16);
            if (i_193_ > 50) {
                int i_194_ = i_192_ + (-i * arg2 + i_189_ * arg1 >> 16);
                if (i_194_ < 3584) {
                    int i_195_ = arg7 * arg3 + arg5 * arg4 >> 16;
                    int i_196_ = i_195_ + i << 9;
                    if (i_196_ / i_193_ > StaticFields.negatedCenterX) {
                        int i_197_ = i_195_ - i << 9;
                        if (i_197_ / i_193_ < StaticFields.halfWidth) {
                            int i_198_ = arg6 * arg2 - i_191_ * arg1 >> 16;
                            int i_199_ = (i_198_ + (i * arg1 + i_190_ * arg2 >> 16) << 9);
                            if (i_199_ / i_193_ > StaticFields.negatedCenterY) {
                                int i_200_ = (i_198_ + (-i * arg1 + i_189_ * arg2 >> 16) << 9);
                                if (i_200_ / i_193_ < StaticFields.halfHeight) {
                                    int i_201_ = 0;
                                    int i_202_ = 0;
                                    if (arg0 != 0) {
                                        i_201_ = Rasterizer.SINE[arg0];
                                        i_202_ = Rasterizer.COSINE[arg0];
                                    }
                                    while_1226_:
                                    do {
                                        if (arg8 > 0L && Class90.aBoolean1417 && i_194_ > 0) {
                                            int i_203_;
                                            int i_204_;
                                            if (i_195_ > 0) {
                                                i_203_ = i_197_ / i_193_;
                                                i_204_ = i_196_ / i_194_;
                                            } else {
                                                i_203_ = i_197_ / i_194_;
                                                i_204_ = i_196_ / i_193_;
                                            }
                                            int i_205_;
                                            int i_206_;
                                            if (i_198_ > 0) {
                                                i_205_ = i_200_ / i_193_;
                                                i_206_ = i_199_ / i_194_;
                                            } else {
                                                i_205_ = i_200_ / i_194_;
                                                i_206_ = i_199_ / i_193_;
                                            }
                                            if ((Class14_Sub2.anInt2726 >= i_203_) && (Class14_Sub2.anInt2726 <= i_204_) && anInt2622 >= i_205_ && (anInt2622 <= i_206_)) {
                                                i_203_ = 999999;
                                                i_204_ = -999999;
                                                i_205_ = 999999;
                                                i_206_ = -999999;
                                                int i_207_ = bounds.maxX;
                                                int i_208_ = bounds.minX;
                                                int i_209_ = bounds.maxZ;
                                                int i_210_ = bounds.minZ;
                                                int[] is = {i_207_, i_208_, i_207_, i_208_, i_207_, i_208_, i_207_, i_208_};
                                                int[] is_211_ = {i_209_, i_209_, i_210_, i_210_, i_209_, i_209_, i_210_, i_210_};
                                                int[] is_212_ = {i_189_, i_189_, i_189_, i_189_, i_190_, i_190_, i_190_, i_190_};
                                                for (int i_213_ = 0; i_213_ < 8; i_213_++) {
                                                    int i_214_ = is[i_213_];
                                                    int i_215_ = is_212_[i_213_];
                                                    int i_216_ = is_211_[i_213_];
                                                    if (arg0 != 0) {
                                                        int i_217_ = ((i_216_ * i_201_ + (i_214_ * i_202_)) >> 16);
                                                        i_216_ = ((i_216_ * i_202_ - (i_214_ * i_201_)) >> 16);
                                                        i_214_ = i_217_;
                                                    }
                                                    i_214_ += arg5;
                                                    i_215_ += arg6;
                                                    i_216_ += arg7;
                                                    int i_218_ = ((i_216_ * arg3 + i_214_ * arg4) >> 16);
                                                    i_216_ = ((i_216_ * arg4 - i_214_ * arg3) >> 16);
                                                    i_214_ = i_218_;
                                                    i_218_ = ((i_215_ * arg2 - i_216_ * arg1) >> 16);
                                                    i_216_ = ((i_215_ * arg1 + i_216_ * arg2) >> 16);
                                                    i_215_ = i_218_;
                                                    if (i_216_ > 0) {
                                                        int i_219_ = ((i_214_ << 9) / i_216_);
                                                        int i_220_ = ((i_215_ << 9) / i_216_);
                                                        if (i_219_ < i_203_)
                                                            i_203_ = i_219_;
                                                        if (i_219_ > i_204_)
                                                            i_204_ = i_219_;
                                                        if (i_220_ < i_205_)
                                                            i_205_ = i_220_;
                                                        if (i_220_ > i_206_)
                                                            i_206_ = i_220_;
                                                    }
                                                }
                                                if ((Class14_Sub2.anInt2726 >= i_203_) && (Class14_Sub2.anInt2726 <= i_204_) && (anInt2622 >= i_205_) && (anInt2622 <= i_206_)) {
                                                    if (aBoolean3687)
                                                        Class7_Sub3.aLongArray2685[Class14_Sub15.anInt2996++] = arg8;
                                                    else {
                                                        if (anIntArray5061.length < vertexCount) {
                                                            anIntArray5061 = (new int
                                                                    [vertexCount]);
                                                            anIntArray5057 = (new int
                                                                    [vertexCount]);
                                                        }
                                                        for (int i_221_ = 0; (i_221_ < realVertexCount); i_221_++) {
                                                            int i_222_ = (vertexX[i_221_]);
                                                            int i_223_ = (vertexY[i_221_]);
                                                            int i_224_ = (vertexZ[i_221_]);
                                                            if (arg0 != 0) {
                                                                int i_225_ = (((i_224_ * i_201_) + (i_222_ * i_202_)) >> 16);
                                                                i_224_ = (((i_224_ * i_202_) - (i_222_ * i_201_)) >> 16);
                                                                i_222_ = i_225_;
                                                            }
                                                            i_222_ += arg5;
                                                            i_223_ += arg6;
                                                            i_224_ += arg7;
                                                            int i_226_ = (((i_224_ * arg3) + (i_222_ * arg4)) >> 16);
                                                            i_224_ = (((i_224_ * arg4) - (i_222_ * arg3)) >> 16);
                                                            i_222_ = i_226_;
                                                            i_226_ = (((i_223_ * arg2) - (i_224_ * arg1)) >> 16);
                                                            i_224_ = (((i_223_ * arg1) + (i_224_ * arg2)) >> 16);
                                                            i_223_ = i_226_;
                                                            if (i_224_ < 50)
                                                                break while_1226_;
                                                            int i_227_ = ((i_222_ << 9) / i_224_);
                                                            int i_228_ = ((i_223_ << 9) / i_224_);
                                                            int i_229_ = (vertexUsageCount[i_221_]);
                                                            int i_230_ = (vertexUsageCount[(i_221_ + 1)]);
                                                            for (int i_231_ = i_229_; (i_231_ < i_230_); i_231_++) {
                                                                int i_232_ = ((vertexIndexes[i_231_]) - 1);
                                                                if (i_232_ == -1)
                                                                    break;
                                                                anIntArray5061[i_232_] = i_227_;
                                                                anIntArray5057[i_232_] = i_228_;
                                                            }
                                                        }
                                                        for (int i_233_ = 0; (i_233_ < triangleCount); i_233_++) {
                                                            short i_234_ = (triangleA[i_233_]);
                                                            short i_235_ = (triangleB[i_233_]);
                                                            short i_236_ = (triangleC[i_233_]);
                                                            if (method1920((Class14_Sub2.anInt2726), (anInt2622), (anIntArray5057[i_234_]), (anIntArray5057[i_235_]), (anIntArray5057[i_236_]), (anIntArray5061[i_234_]), (anIntArray5061[i_235_]), (anIntArray5061[i_236_]))) {
                                                                Class7_Sub3.aLongArray2685[Class14_Sub15.anInt2996++] = arg8;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } while (false);
                                    GL gl = OpenGLManager.gl;
                                    GL11.glPushMatrix();
                                    GL11.glTranslatef((float) arg5, (float) arg6, (float) arg7);
                                    GL11.glRotatef((float) arg0 * 0.17578125F, 0.0F, 1.0F, 0.0F);
                                    render();
                                    GL11.glPopMatrix();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    */
    public void rotateCCW() {
        for (int i = 0; i < realVertexCount; i++) {
            int i_237_ = vertexZ[i];
            vertexZ[i] = vertexX[i];
            vertexX[i] = -i_237_;
        }
        bounds.upToDate = false;
        vertexPositions.upToDate = false;
    }

    public void translate(int xOffset, int yOffset, int zOffset) {
        for (int i = 0; i < realVertexCount; i++) {
            vertexX[i] += xOffset;
            vertexY[i] += yOffset;
            vertexZ[i] += zOffset;
        }
        bounds.upToDate = false;
        vertexPositions.upToDate = false;
    }

    public static float[] method1911(int arg0, int arg1, int arg2, int angle, float arg4, float arg5, float arg6) {
        float[] fs = new float[9];
        float[] fs_238_ = new float[9];
        float xRotationOffset = (float) Math.cos((double) ((float) angle * 0.024543693F));
        float yRotationOffset = (float) Math.sin((double) ((float) angle * 0.024543693F));
        float oneMinusXRotOffset = 1.0F - xRotationOffset;
        fs[0] = xRotationOffset;
        fs[1] = 0.0F;
        fs[2] = yRotationOffset;
        fs[3] = 0.0F;
        fs[4] = 1.0F;
        fs[5] = 0.0F;
        fs[6] = -yRotationOffset;
        fs[7] = 0.0F;
        fs[8] = xRotationOffset;
        float[] fs_241_ = new float[9];
        float f_242_ = 1.0F;
        float f_243_ = 0.0F;
        xRotationOffset = (float) arg1 / 32767.0F;
        yRotationOffset = -(float) Math.sqrt((double) (1.0F - xRotationOffset * xRotationOffset));
        oneMinusXRotOffset = 1.0F - xRotationOffset;
        float f_244_ = (float) Math.sqrt((double) (arg0 * arg0 + arg2 * arg2));
        if (f_244_ == 0.0F && xRotationOffset == 0.0F)
            fs_238_ = fs;
        else {
            if (f_244_ != 0.0F) {
                f_242_ = (float) -arg2 / f_244_;
                f_243_ = (float) arg0 / f_244_;
            }
            fs_241_[0] = xRotationOffset + f_242_ * f_242_ * oneMinusXRotOffset;
            fs_241_[1] = f_243_ * yRotationOffset;
            fs_241_[2] = f_243_ * f_242_ * oneMinusXRotOffset;
            fs_241_[3] = -f_243_ * yRotationOffset;
            fs_241_[4] = xRotationOffset;
            fs_241_[5] = f_242_ * yRotationOffset;
            fs_241_[6] = f_242_ * f_243_ * oneMinusXRotOffset;
            fs_241_[7] = -f_242_ * yRotationOffset;
            fs_241_[8] = xRotationOffset + f_243_ * f_243_ * oneMinusXRotOffset;
            fs_238_[0] = fs[0] * fs_241_[0] + fs[1] * fs_241_[3] + fs[2] * fs_241_[6];
            fs_238_[1] = fs[0] * fs_241_[1] + fs[1] * fs_241_[4] + fs[2] * fs_241_[7];
            fs_238_[2] = fs[0] * fs_241_[2] + fs[1] * fs_241_[5] + fs[2] * fs_241_[8];
            fs_238_[3] = fs[3] * fs_241_[0] + fs[4] * fs_241_[3] + fs[5] * fs_241_[6];
            fs_238_[4] = fs[3] * fs_241_[1] + fs[4] * fs_241_[4] + fs[5] * fs_241_[7];
            fs_238_[5] = fs[3] * fs_241_[2] + fs[4] * fs_241_[5] + fs[5] * fs_241_[8];
            fs_238_[6] = fs[6] * fs_241_[0] + fs[7] * fs_241_[3] + fs[8] * fs_241_[6];
            fs_238_[7] = fs[6] * fs_241_[1] + fs[7] * fs_241_[4] + fs[8] * fs_241_[7];
            fs_238_[8] = fs[6] * fs_241_[2] + fs[7] * fs_241_[5] + fs[8] * fs_241_[8];
        }
        fs_238_[0] *= arg4;
        fs_238_[1] *= arg4;
        fs_238_[2] *= arg4;
        fs_238_[3] *= arg5;
        fs_238_[4] *= arg5;
        fs_238_[5] *= arg5;
        fs_238_[6] *= arg6;
        fs_238_[7] *= arg6;
        fs_238_[8] *= arg6;
        return fs_238_;
    }

    public void scaleDown(int scaleX, int scaleY, int scaleZ) {
        for (int i = 0; i < realVertexCount; i++) {
            vertexX[i] = vertexX[i] * scaleX >> 7;
            vertexY[i] = vertexY[i] * scaleY >> 7;
            vertexZ[i] = vertexZ[i] * scaleZ >> 7;
        }
        bounds.upToDate = false;
        vertexPositions.upToDate = false;
    }

    public int getBoundsNear() {
        if (!bounds.upToDate)
            updateBounds();
        return bounds.minZ;
    }

    public void rotateCW() {
        for (int i = 0; i < realVertexCount; i++) {
            int i_245_ = vertexX[i];
            vertexX[i] = vertexZ[i];
            vertexZ[i] = -i_245_;
        }
        bounds.upToDate = false;
        vertexPositions.upToDate = false;
    }

    public void method1788(Object arg0, int arg1, int arg2, int arg3, boolean arg4) {
        ModelRendererGL modelRendererGL = (ModelRendererGL) arg0;
        if (triangleCount != 0 && modelRendererGL.triangleCount != 0) {
            int i = modelRendererGL.realVertexCount;
            int[] is = modelRendererGL.vertexX;
            int[] is_246_ = modelRendererGL.vertexY;
            int[] is_247_ = modelRendererGL.vertexZ;
            short[] is_248_ = modelRendererGL.normalX;
            short[] is_249_ = modelRendererGL.normalY;
            short[] is_250_ = modelRendererGL.normalZ;
            short[] is_251_ = modelRendererGL.normalMagnitude;
            short[] is_252_;
            short[] is_253_;
            short[] is_254_;
            short[] is_255_;
            if (aNormals_5039 != null) {
                is_252_ = aNormals_5039.normalX;
                is_253_ = aNormals_5039.normalY;
                is_254_ = aNormals_5039.normalZ;
                is_255_ = aNormals_5039.normalMagnitude;
            } else {
                is_252_ = null;
                is_253_ = null;
                is_254_ = null;
                is_255_ = null;
            }
            short[] is_256_;
            short[] is_257_;
            short[] is_258_;
            short[] is_259_;
            if (modelRendererGL.aNormals_5039 != null) {
                is_256_ = modelRendererGL.aNormals_5039.normalX;
                is_257_ = modelRendererGL.aNormals_5039.normalY;
                is_258_ = modelRendererGL.aNormals_5039.normalZ;
                is_259_ = modelRendererGL.aNormals_5039.normalMagnitude;
            } else {
                is_256_ = null;
                is_257_ = null;
                is_258_ = null;
                is_259_ = null;
            }
            int[] is_260_ = modelRendererGL.vertexUsageCount;
            short[] is_261_ = modelRendererGL.vertexIndexes;
            if (!modelRendererGL.bounds.upToDate)
                modelRendererGL.updateBounds();
            int i_262_ = modelRendererGL.bounds.maxY;
            int i_263_ = modelRendererGL.bounds.minY;
            int i_264_ = modelRendererGL.bounds.maxX;
            int i_265_ = modelRendererGL.bounds.minX;
            int i_266_ = modelRendererGL.bounds.maxZ;
            int i_267_ = modelRendererGL.bounds.minZ;
            for (int i_268_ = 0; i_268_ < realVertexCount; i_268_++) {
                int i_269_ = vertexY[i_268_] - arg2;
                if (i_269_ >= i_262_ && i_269_ <= i_263_) {
                    int i_270_ = vertexX[i_268_] - arg1;
                    if (i_270_ >= i_264_ && i_270_ <= i_265_) {
                        int i_271_ = vertexZ[i_268_] - arg3;
                        if (i_271_ >= i_266_ && i_271_ <= i_267_) {
                            int i_272_ = -1;
                            int i_273_ = vertexUsageCount[i_268_];
                            int i_274_ = vertexUsageCount[i_268_ + 1];
                            for (int i_275_ = i_273_; i_275_ < i_274_; i_275_++) {
                                i_272_ = vertexIndexes[i_275_] - 1;
                                if (i_272_ == -1 || normalMagnitude[i_272_] != 0)
                                    break;
                            }
                            if (i_272_ != -1) {
                                for (int i_276_ = 0; i_276_ < i; i_276_++) {
                                    if (i_270_ == is[i_276_] && i_271_ == is_247_[i_276_] && i_269_ == is_246_[i_276_]) {
                                        int i_277_ = -1;
                                        i_273_ = is_260_[i_276_];
                                        i_274_ = is_260_[i_276_ + 1];
                                        for (int i_278_ = i_273_; i_278_ < i_274_; i_278_++) {
                                            i_277_ = is_261_[i_278_] - 1;
                                            if (i_277_ == -1 || is_251_[i_277_] != 0)
                                                break;
                                        }
                                        if (i_277_ != -1) {
                                            if (is_252_ == null) {
                                                aNormals_5039 = new Normals();
                                                is_252_ = aNormals_5039.normalX = (cloneArray(8111, normalX));
                                                is_253_ = aNormals_5039.normalY = (cloneArray(8111, normalY));
                                                is_254_ = aNormals_5039.normalZ = (cloneArray(8111, normalZ));
                                                is_255_ = aNormals_5039.normalMagnitude = (cloneArray(8111, normalMagnitude));
                                            }
                                            if (is_256_ == null) {
                                                Normals normals = (modelRendererGL.aNormals_5039 = new Normals());
                                                is_256_ = normals.normalX = (cloneArray(8111, is_248_));
                                                is_257_ = normals.normalY = (cloneArray(8111, is_249_));
                                                is_258_ = normals.normalZ = (cloneArray(8111, is_250_));
                                                is_259_ = normals.normalMagnitude = (cloneArray(8111, is_251_));
                                            }
                                            short i_279_ = normalX[i_272_];
                                            short i_280_ = normalY[i_272_];
                                            short i_281_ = normalZ[i_272_];
                                            short i_282_ = normalMagnitude[i_272_];
                                            i_273_ = is_260_[i_276_];
                                            i_274_ = is_260_[i_276_ + 1];
                                            for (int i_283_ = i_273_; i_283_ < i_274_; i_283_++) {
                                                int i_284_ = is_261_[i_283_] - 1;
                                                if (i_284_ == -1)
                                                    break;
                                                if (is_259_[i_284_] != 0) {
                                                    is_256_[i_284_] += i_279_;
                                                    is_257_[i_284_] += i_280_;
                                                    is_258_[i_284_] += i_281_;
                                                    is_259_[i_284_] += i_282_;
                                                }
                                            }
                                            i_279_ = is_248_[i_277_];
                                            i_280_ = is_249_[i_277_];
                                            i_281_ = is_250_[i_277_];
                                            i_282_ = is_251_[i_277_];
                                            i_273_ = vertexUsageCount[i_268_];
                                            i_274_ = vertexUsageCount[i_268_ + 1];
                                            for (int i_285_ = i_273_; i_285_ < i_274_; i_285_++) {
                                                int i_286_ = (vertexIndexes[i_285_] - 1);
                                                if (i_286_ == -1)
                                                    break;
                                                if (is_255_[i_286_] != 0) {
                                                    is_252_[i_286_] += i_279_;
                                                    is_253_[i_286_] += i_280_;
                                                    is_254_[i_286_] += i_281_;
                                                    is_255_[i_286_] += i_282_;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int getBoundsFar() {
        if (!bounds.upToDate)
            updateBounds();
        return bounds.maxZ;
    }

    public void invertZandSwapAC() {
        for (int i = 0; i < realVertexCount; i++)
            vertexZ[i] = -vertexZ[i];
        if (normalZ != null) {
            for (int i = 0; i < vertexCount; i++)
                normalZ[i] = (short) -normalZ[i];
        }
        for (int i = 0; i < triangleCount; i++) {
            short triA = triangleA[i];
            triangleA[i] = triangleC[i];
            triangleC[i] = triA;
        }
        bounds.upToDate = false;
        vertexPositions.upToDate = false;
        if (vertexNormals != null)
            vertexNormals.upToDate = false;
        triangleIndices.upToDate = false;
    }

    public Object method1791(int arg0, int arg1, int arg2) {
        aBoolean5009 = false;
        if (aNormals_5039 != null) {
            normalX = aNormals_5039.normalX;
            normalY = aNormals_5039.normalY;
            normalZ = aNormals_5039.normalZ;
            normalMagnitude = aNormals_5039.normalMagnitude;
            aNormals_5039 = null;
        }
        return this;
    }

    public void calcSkinning() {
        if (vertexVSkin != null) {
            int[] is = new int[256];
            int i = 0;
            for (int i_288_ = 0; i_288_ < realVertexCount; i_288_++) {
                int i_289_ = vertexVSkin[i_288_] & 0xff;
                is[i_289_]++;
                if (i_289_ > i)
                    i = i_289_;
            }
            vertexSkin = new int[i + 1][];
            for (int i_290_ = 0; i_290_ <= i; i_290_++) {
                vertexSkin[i_290_] = new int[is[i_290_]];
                is[i_290_] = 0;
            }
            for (int i_291_ = 0; i_291_ < realVertexCount; i_291_++) {
                int i_292_ = vertexVSkin[i_291_] & 0xff;
                vertexSkin[i_292_][is[i_292_]++] = i_291_;
            }
            vertexVSkin = null;
        }
        if (triangleTSkin != null) {
            int[] is = new int[256];
            int i = 0;
            for (int i_293_ = 0; i_293_ < triangleCount; i_293_++) {
                int i_294_ = triangleTSkin[i_293_] & 0xff;
                is[i_294_]++;
                if (i_294_ > i)
                    i = i_294_;
            }
            triangleSkin = new int[i + 1][];
            for (int i_295_ = 0; i_295_ <= i; i_295_++) {
                triangleSkin[i_295_] = new int[is[i_295_]];
                is[i_295_] = 0;
            }
            for (int i_296_ = 0; i_296_ < triangleCount; i_296_++) {
                int i_297_ = triangleTSkin[i_296_] & 0xff;
                triangleSkin[i_297_][is[i_297_]++] = i_296_;
            }
            triangleTSkin = null;
        }
    }

    public int getBoundsTop() {
        if (!bounds.upToDate)
            updateBounds();
        return bounds.maxY;
    }

    public static short[] subArray(short[] arg0, int arg1) {
        short[] is = new short[arg1];
        System.arraycopy(arg0, 0, is, 0, arg1);
        return is;
    }

    public void rotateAlongYWithNormals(int angle) {
        if (normalX == null)
            rotateAlongY(angle);
        else {
            int i = Rasterizer.SINE[angle];
            int i_298_ = Rasterizer.COSINE[angle];
            for (int i_299_ = 0; i_299_ < realVertexCount; i_299_++) {
                int i_300_ = ((vertexZ[i_299_] * i + vertexX[i_299_] * i_298_) >> 16);
                vertexZ[i_299_] = (vertexZ[i_299_] * i_298_ - vertexX[i_299_] * i) >> 16;
                vertexX[i_299_] = i_300_;
            }
            for (int i_301_ = 0; i_301_ < vertexCount; i_301_++) {
                int i_302_ = ((normalZ[i_301_] * i + normalX[i_301_] * i_298_) >> 16);
                normalZ[i_301_] = (short) ((normalZ[i_301_] * i_298_ - normalX[i_301_] * i) >> 16);
                normalX[i_301_] = (short) i_302_;
            }
            bounds.upToDate = false;
            vertexPositions.upToDate = false;
            if (vertexNormals != null)
                vertexNormals.upToDate = false;
        }
    }

    public ModelRendererGL() {
        aBoolean5009 = false;
        dirtyBuffers = (byte) 0;
        vertexCount = 0;
        aByte5026 = (byte) 0;
        realVertexCount = 0;
    }

    public void invertXZ() {
        for (int i = 0; i < realVertexCount; i++) {
            vertexX[i] = -vertexX[i];
            vertexZ[i] = -vertexZ[i];
        }
        bounds.upToDate = false;
        vertexPositions.upToDate = false;
    }

    public ModelRendererGL(Model model, int intensity, int falloff, boolean arg3) {
        aBoolean5009 = false;
        dirtyBuffers = (byte) 0;
        vertexCount = 0;
        aByte5026 = (byte) 0;
        realVertexCount = 0;
        int[] is = new int[model.triangleCount];
        vertexUsageCount = new int[model.vertexCount + 1];
        for (int i = 0; i < model.triangleCount; i++) {
            if ((model.triangleDrawType == null || (model.triangleDrawType[i] & 1 )!= 2) && (model.triangleTexture == null || model.triangleTexture[i] == -1 )) {
                is[triangleCount++] = i;
                vertexUsageCount[model.triangleA[i]]++;
                vertexUsageCount[model.triangleB[i]]++;
                vertexUsageCount[model.triangleC[i]]++;
            }
        }
        long[] ls = new long[triangleCount];
        for (int i = 0; i < triangleCount; i++) {
            int i_303_ = is[i];
            int i_304_ = 0;
            int i_305_ = 0;
           // int i_306_ = 0;
           // int i_307_ = 0;
            int i_308_ = -1;
            if (model.triangleTexture != null) {
                i_308_ = model.triangleTexture[i_303_];
                if (i_308_ != -1) {
                 //   i_306_ = Rasterizer.modelTextureSource.method12(true, i_308_ & 0xffff);
                //    i_307_ = Rasterizer.modelTextureSource.method8((byte) 123, i_308_ & 0xffff);
                }
            }
            boolean bool = ((model.triangleAlpha != null && model.triangleAlpha[i_303_] != 0) || i_308_ != -1 );
            if ((arg3 || bool) && model.facePriority != null)
                i_304_ += model.facePriority[i_303_] << 17;
            if (bool)
                i_304_ += 65536;
          //  i_304_ += (i_306_ & 0xff) << 8;
          //  i_304_ += i_307_ & 0xff;
            i_305_ += (i_308_ & 0xffff) << 16;
            i_305_ += i & 0xffff;
            ls[i] = ((long) i_304_ << 32) + (long) i_305_;
        }
        //Class117.method1602(is, (byte) 125, ls);
        realVertexCount = model.vertexCount;
        vertexX = model.vertexX;
        vertexY = model.vertexY;
        vertexZ = model.vertexZ;
        vertexVSkin = model.vertexVSkin;
        int vertexCount = triangleCount * 3;
        normalX = new short[vertexCount];
        normalY = new short[vertexCount];
        normalZ = new short[vertexCount];
        normalMagnitude = new short[vertexCount];
        textureU = new float[vertexCount];
        textureV = new float[vertexCount];
        triangleColour = new short[triangleCount];
        triangleAlpha = new byte[triangleCount];
        triangleA = new short[triangleCount];
        triangleB = new short[triangleCount];
        triangleC = new short[triangleCount];
        triangleTexture = new short[triangleCount];
        if (model.triangleTSkin != null)
            triangleTSkin = new byte[triangleCount];
        bounds = new ModelBounds();
        vertexPositions = new VertexBufferPointer();
        vertexColours = new VertexBufferPointer();
        if (Class7_Sub1.useLighting)
            vertexNormals = new VertexBufferPointer();
        vertexTexCoords = new VertexBufferPointer();
        triangleIndices = new VertexBufferPointer();
        this.intensity = (short) intensity;
        this.falloff = (short) falloff;
        vertexIndexes = new short[vertexCount];
        aLongArray5048 = new long[vertexCount];
        int totalVertexUsageCount = 0;
        for (int vertexIndex = 0; vertexIndex < model.vertexCount; vertexIndex++) {
            int vertexUsageCount = this.vertexUsageCount[vertexIndex];
            this.vertexUsageCount[vertexIndex] = totalVertexUsageCount;
            totalVertexUsageCount += vertexUsageCount;
        }
        vertexUsageCount[model.vertexCount] = totalVertexUsageCount;
        int[] is_312_ = null;
        int[] is_313_ = null;
        int[] is_314_ = null;
        float[][] fs = null;
        if (model.triangleDrawType != null && model.textureTriangleCount!= 0 ) {
            int i_315_ = model.textureTriangleCount;
            int[] is_316_ = new int[i_315_];
            int[] is_317_ = new int[i_315_];
            int[] is_318_ = new int[i_315_];
            int[] is_319_ = new int[i_315_];
            int[] is_320_ = new int[i_315_];
            int[] is_321_ = new int[i_315_];
            for (int i_322_ = 0; i_322_ < i_315_; i_322_++) {
                is_316_[i_322_] = 2147483647;
                is_317_[i_322_] = -2147483647;
                is_318_[i_322_] = 2147483647;
                is_319_[i_322_] = -2147483647;
                is_320_[i_322_] = 2147483647;
                is_321_[i_322_] = -2147483647;
            }
            for (int i_323_ = 0; i_323_ < triangleCount; i_323_++) {
                int i_324_ = is[i_323_];
                if ((model.triangleDrawType[i_324_] >> 2) != -1) {
                    int i_325_ = (model.triangleDrawType[i_324_] >> 2) & 0xff;
                    for (int trianglePointPtr = 0; trianglePointPtr < 3; trianglePointPtr++) {
                        int vertexPointer;
                        if (trianglePointPtr == 0)
                            vertexPointer = model.triangleA[i_324_];
                        else if (trianglePointPtr == 1)
                            vertexPointer = model.triangleB[i_324_];
                        else
                            vertexPointer = model.triangleC[i_324_];
                        int i_328_ = model.vertexX[vertexPointer];
                        int i_329_ = model.vertexY[vertexPointer];
                        int i_330_ = model.vertexZ[vertexPointer];
                        if (i_328_ < is_316_[i_325_])
                            is_316_[i_325_] = i_328_;
                        if (i_328_ > is_317_[i_325_])
                            is_317_[i_325_] = i_328_;
                        if (i_329_ < is_318_[i_325_])
                            is_318_[i_325_] = i_329_;
                        if (i_329_ > is_319_[i_325_])
                            is_319_[i_325_] = i_329_;
                        if (i_330_ < is_320_[i_325_])
                            is_320_[i_325_] = i_330_;
                        if (i_330_ > is_321_[i_325_])
                            is_321_[i_325_] = i_330_;
                    }
                }
            }
            is_312_ = new int[i_315_];
            is_313_ = new int[i_315_];
            is_314_ = new int[i_315_];
            fs = new float[i_315_][];
           /* for (int i_331_ = 0; i_331_ < i_315_; i_331_++) {
                byte i_332_ = model.aByteArray3514[i_331_];
                if (i_332_ > 0) {
                    is_312_[i_331_] = (is_316_[i_331_] + is_317_[i_331_]) / 2;
                    is_313_[i_331_] = (is_318_[i_331_] + is_319_[i_331_]) / 2;
                    is_314_[i_331_] = (is_320_[i_331_] + is_321_[i_331_]) / 2;
                    float f;
                    float f_333_;
                    float f_334_;
                    if (i_332_ == 1) {
                        int i_335_ = model.aShortArray3512[i_331_];
                        if (i_335_ == 0) {
                            f = 1.0F;
                            f_334_ = 1.0F;
                        } else if (i_335_ > 0) {
                            f = 1.0F;
                            f_334_ = (float) i_335_ / 1024.0F;
                        } else {
                            f_334_ = 1.0F;
                            f = (float) -i_335_ / 1024.0F;
                        }
                        f_333_ = 64.0F / (float) (model.aShortArray3522[i_331_] & 0xffff);
                    } else if (i_332_ == 2) {
                        f = 64.0F / (float) (model.aShortArray3512[i_331_] & 0xffff);
                        f_333_ = 64.0F / (float) (model.aShortArray3522[i_331_] & 0xffff);
                        f_334_ = 64.0F / (float) (model.aShortArray3527[i_331_] & 0xffff);
                    } else {
                        f = (float) model.aShortArray3512[i_331_] / 1024.0F;
                        f_333_ = (float) model.aShortArray3522[i_331_] / 1024.0F;
                        f_334_ = (float) model.aShortArray3527[i_331_] / 1024.0F;
                    }
                    fs[i_331_] = method1911(model.triPIndex[i_331_], model.triMIndex[i_331_], model.triNIndex[i_331_], model.aByteArray3516[i_331_] & 0xff, f, f_333_, f_334_);
                }
            } */
        }
        for (int destTriangleIdx = 0; destTriangleIdx < triangleCount; destTriangleIdx++) {
            int sourceTriangleIndex = is[destTriangleIdx];
            int sourceColour = model.triangleColour[sourceTriangleIndex] & 0xffff;
            short sourceTexture;
            if (model.triangleTexture == null)
                sourceTexture = (short) -1;
            else
                sourceTexture = model.triangleTexture[sourceTriangleIndex];
            int i_340_;
            if (model.triangleDrawType == null)
                i_340_ = -1;
            else
                i_340_ = model.triangleDrawType[sourceTriangleIndex] >> 2;
            int sourceAlpha;
            if (model.triangleAlpha == null)
                sourceAlpha = 0;
            else
                sourceAlpha = model.triangleAlpha[sourceTriangleIndex] & 0xff;
            float tcAU = 0.0F;
            float tcAV = 0.0F;
            float tcBU = 0.0F;
            float tcBV = 0.0F;
            float tcCU = 0.0F;
            float tcCV = 0.0F;
            int i_347_ = 0;
            int i_348_ = 0;
            int i_349_ = 0;
            if (sourceTexture != -1) {
                if (i_340_ == -1) {
                    tcAU = 0.0F;
                    tcAV = 1.0F;
                    tcBU = 1.0F;
                    tcBV = 1.0F;
                    i_347_ = 1;
                    tcCU = 0.0F;
                    tcCV = 0.0F;
                    i_348_ = 2;
                } else {
                    i_340_ &= 0xff;
                    byte i_350_ = 0;//model.aByteArray3514[i_340_];
                    if (i_350_ == 0) {
                        int i_351_ = model.triangleA[sourceTriangleIndex];
                        int i_352_ = model.triangleB[sourceTriangleIndex];
                        int i_353_ = model.triangleC[sourceTriangleIndex];
                        int pI = model.triPIndex[i_340_];
                        int mI = model.triMIndex[i_340_];
                        int nI = model.triNIndex[i_340_];
                        float Px = (float) model.vertexX[pI];
                        float Py = (float) model.vertexY[pI];
                        float Pz = (float) model.vertexZ[pI];
                        float f_360_ = (float) model.vertexX[mI] - Px;
                        float f_361_ = (float) model.vertexY[mI] - Py;
                        float f_362_ = (float) model.vertexZ[mI] - Pz;
                        float f_363_ = (float) model.vertexX[nI] - Px;
                        float f_364_ = (float) model.vertexY[nI] - Py;
                        float f_365_ = (float) model.vertexZ[nI] - Pz;
                        float f_366_ = (float) model.vertexX[i_351_] - Px;
                        float f_367_ = (float) model.vertexY[i_351_] - Py;
                        float f_368_ = (float) model.vertexZ[i_351_] - Pz;
                        float f_369_ = (float) model.vertexX[i_352_] - Px;
                        float f_370_ = (float) model.vertexY[i_352_] - Py;
                        float f_371_ = (float) model.vertexZ[i_352_] - Pz;
                        float f_372_ = (float) model.vertexX[i_353_] - Px;
                        float f_373_ = (float) model.vertexY[i_353_] - Py;
                        float f_374_ = (float) model.vertexZ[i_353_] - Pz;
                        float f_375_ = f_361_ * f_365_ - f_362_ * f_364_;
                        float f_376_ = f_362_ * f_363_ - f_360_ * f_365_;
                        float f_377_ = f_360_ * f_364_ - f_361_ * f_363_;
                        float f_378_ = f_364_ * f_377_ - f_365_ * f_376_;
                        float f_379_ = f_365_ * f_375_ - f_363_ * f_377_;
                        float f_380_ = f_363_ * f_376_ - f_364_ * f_375_;
                        float f_381_ = 1.0F / (f_378_ * f_360_ + f_379_ * f_361_ + f_380_ * f_362_);
                        tcAU = (f_378_ * f_366_ + f_379_ * f_367_ + f_380_ * f_368_) * f_381_;
                        tcBU = (f_378_ * f_369_ + f_379_ * f_370_ + f_380_ * f_371_) * f_381_;
                        tcCU = (f_378_ * f_372_ + f_379_ * f_373_ + f_380_ * f_374_) * f_381_;
                        f_378_ = f_361_ * f_377_ - f_362_ * f_376_;
                        f_379_ = f_362_ * f_375_ - f_360_ * f_377_;
                        f_380_ = f_360_ * f_376_ - f_361_ * f_375_;
                        f_381_ = 1.0F / (f_378_ * f_363_ + f_379_ * f_364_ + f_380_ * f_365_);
                        tcAV = (f_378_ * f_366_ + f_379_ * f_367_ + f_380_ * f_368_) * f_381_;
                        tcBV = (f_378_ * f_369_ + f_379_ * f_370_ + f_380_ * f_371_) * f_381_;
                        tcCV = (f_378_ * f_372_ + f_379_ * f_373_ + f_380_ * f_374_) * f_381_;
                    } /*else {
                        int i_382_ = model.triangleA[sourceTriangleIndex];
                        int i_383_ = model.triangleB[sourceTriangleIndex];
                        int i_384_ = model.triangleC[sourceTriangleIndex];
                        int i_385_ = is_312_[i_340_];
                        int i_386_ = is_313_[i_340_];
                        int i_387_ = is_314_[i_340_];
                        float[] fs_388_ = fs[i_340_];
                        byte i_389_ = model.aByteArray3548[i_340_];
                        float f_390_ = (float) model.aByteArray3554[i_340_] / 256.0F;
                        if (i_350_ == 1) {
                            float f_391_ = ((float) (model.aShortArray3527[i_340_] & 0xffff) / 1024.0F);
                            method1921(model.vertexX[i_382_], model.vertexY[i_382_], model.vertexZ[i_382_], i_385_, i_386_, i_387_, fs_388_, f_391_, i_389_, f_390_);
                            tcAU = aFloat5064;
                            tcAV = aFloat5060;
                            method1921(model.vertexX[i_383_], model.vertexY[i_383_], model.vertexZ[i_383_], i_385_, i_386_, i_387_, fs_388_, f_391_, i_389_, f_390_);
                            tcBU = aFloat5064;
                            tcBV = aFloat5060;
                            method1921(model.vertexX[i_384_], model.vertexY[i_384_], model.vertexZ[i_384_], i_385_, i_386_, i_387_, fs_388_, f_391_, i_389_, f_390_);
                            tcCU = aFloat5064;
                            tcCV = aFloat5060;
                            float f_392_ = f_391_ / 2.0F;
                            if ((i_389_ & 0x1) == 0) {
                                if (tcBU - tcAU > f_392_) {
                                    tcBU -= f_391_;
                                    i_347_ = 1;
                                } else if (tcAU - tcBU > f_392_) {
                                    tcBU += f_391_;
                                    i_347_ = 2;
                                }
                                if (tcCU - tcAU > f_392_) {
                                    tcCU -= f_391_;
                                    i_348_ = 1;
                                } else if (tcAU - tcCU > f_392_) {
                                    tcCU += f_391_;
                                    i_348_ = 2;
                                }
                            } else {
                                if (tcBV - tcAV > f_392_) {
                                    tcBV -= f_391_;
                                    i_347_ = 1;
                                } else if (tcAV - tcBV > f_392_) {
                                    tcBV += f_391_;
                                    i_347_ = 2;
                                }
                                if (tcCV - tcAV > f_392_) {
                                    tcCV -= f_391_;
                                    i_348_ = 1;
                                } else if (tcAV - tcCV > f_392_) {
                                    tcCV += f_391_;
                                    i_348_ = 2;
                                }
                            }
                        } else if (i_350_ == 2) {
                            float f_393_ = (float) model.aByteArray3518[i_340_] / 256.0F;
                            float f_394_ = (float) model.aByteArray3529[i_340_] / 256.0F;
                            int i_395_ = (model.vertexX[i_383_] - model.vertexX[i_382_]);
                            int i_396_ = (model.vertexY[i_383_] - model.vertexY[i_382_]);
                            int i_397_ = (model.vertexZ[i_383_] - model.vertexZ[i_382_]);
                            int i_398_ = (model.vertexX[i_384_] - model.vertexX[i_382_]);
                            int i_399_ = (model.vertexY[i_384_] - model.vertexY[i_382_]);
                            int i_400_ = (model.vertexZ[i_384_] - model.vertexZ[i_382_]);
                            int i_401_ = i_396_ * i_400_ - i_399_ * i_397_;
                            int i_402_ = i_397_ * i_398_ - i_400_ * i_395_;
                            int i_403_ = i_395_ * i_399_ - i_398_ * i_396_;
                            float f_404_ = 64.0F / (float) (model.aShortArray3512[i_340_] & 0xffff);
                            float f_405_ = 64.0F / (float) (model.aShortArray3522[i_340_] & 0xffff);
                            float f_406_ = 64.0F / (float) (model.aShortArray3527[i_340_] & 0xffff);
                            float f_407_ = (((float) i_401_ * fs_388_[0] + (float) i_402_ * fs_388_[1] + (float) i_403_ * fs_388_[2]) / f_404_);
                            float f_408_ = (((float) i_401_ * fs_388_[3] + (float) i_402_ * fs_388_[4] + (float) i_403_ * fs_388_[5]) / f_405_);
                            float f_409_ = (((float) i_401_ * fs_388_[6] + (float) i_402_ * fs_388_[7] + (float) i_403_ * fs_388_[8]) / f_406_);
                            i_349_ = method1898(f_407_, f_408_, f_409_);
                            method1888(model.vertexX[i_382_], model.vertexY[i_382_], model.vertexZ[i_382_], i_385_, i_386_, i_387_, i_349_, fs_388_, i_389_, f_390_, f_393_, f_394_);
                            tcAU = aFloat5056;
                            tcAV = aFloat5063;
                            method1888(model.vertexX[i_383_], model.vertexY[i_383_], model.vertexZ[i_383_], i_385_, i_386_, i_387_, i_349_, fs_388_, i_389_, f_390_, f_393_, f_394_);
                            tcBU = aFloat5056;
                            tcBV = aFloat5063;
                            method1888(model.vertexX[i_384_], model.vertexY[i_384_], model.vertexZ[i_384_], i_385_, i_386_, i_387_, i_349_, fs_388_, i_389_, f_390_, f_393_, f_394_);
                            tcCU = aFloat5056;
                            tcCV = aFloat5063;
                        } else if (i_350_ == 3) {
                            method1916(model.vertexX[i_382_], model.vertexY[i_382_], model.vertexZ[i_382_], i_385_, i_386_, i_387_, fs_388_, i_389_, f_390_);
                            tcAU = aFloat5062;
                            tcAV = aFloat5058;
                            method1916(model.vertexX[i_383_], model.vertexY[i_383_], model.vertexZ[i_383_], i_385_, i_386_, i_387_, fs_388_, i_389_, f_390_);
                            tcBU = aFloat5062;
                            tcBV = aFloat5058;
                            method1916(model.vertexX[i_384_], model.vertexY[i_384_], model.vertexZ[i_384_], i_385_, i_386_, i_387_, fs_388_, i_389_, f_390_);
                            tcCU = aFloat5062;
                            tcCV = aFloat5058;
                            if ((i_389_ & 0x1) == 0) {
                                if (tcBU - tcAU > 0.5F) {
                                    tcBU--;
                                    i_347_ = 1;
                                } else if (tcAU - tcBU > 0.5F) {
                                    tcBU++;
                                    i_347_ = 2;
                                }
                                if (tcCU - tcAU > 0.5F) {
                                    tcCU--;
                                    i_348_ = 1;
                                } else if (tcAU - tcCU > 0.5F) {
                                    tcCU++;
                                    i_348_ = 2;
                                }
                            } else {
                                if (tcBV - tcAV > 0.5F) {
                                    tcBV--;
                                    i_347_ = 1;
                                } else if (tcAV - tcBV > 0.5F) {
                                    tcBV++;
                                    i_347_ = 2;
                                }
                                if (tcCV - tcAV > 0.5F) {
                                    tcCV--;
                                    i_348_ = 1;
                                } else if (tcAV - tcCV > 0.5F) {
                                    tcCV++;
                                    i_348_ = 2;
                                }
                            }
                        }
                    }     */
                }
            }
            model.calculateNormals508();
            byte i_410_;
            if (model.triangleDrawType == null)
                i_410_ = (byte) 0;
            else
                i_410_ = (byte) ((byte) model.triangleDrawType[sourceTriangleIndex] & 1);
            if (i_410_ == 0) {
                long arg2ofAV = ((long) (i_340_ << 2) + (((long) (i_349_ << 24) + (long) (sourceColour << 8) + (long) sourceAlpha) << 32));
                int sourceTriangleA = model.triangleA[sourceTriangleIndex];
                VertexNormal sourceNormalA = model.vertexNormals[sourceTriangleA];
                triangleA[destTriangleIdx] = addVertex(model, sourceTriangleA, arg2ofAV, sourceNormalA.x, sourceNormalA.y, sourceNormalA.z, sourceNormalA.magnitude, tcAU, tcAV);
                int sourceTriangleB = model.triangleB[sourceTriangleIndex];
                VertexNormal sourceNormalB = model.vertexNormals[sourceTriangleB];
                triangleB[destTriangleIdx] = addVertex(model, sourceTriangleB, arg2ofAV + (long) i_347_, sourceNormalB.x, sourceNormalB.y, sourceNormalB.z, sourceNormalB.magnitude, tcBU, tcBV);
                int sourceTriangleC = model.triangleC[sourceTriangleIndex];
                VertexNormal sourceNormalC = model.vertexNormals[sourceTriangleC];
                triangleC[destTriangleIdx] = addVertex(model, sourceTriangleC, arg2ofAV + (long) i_348_, sourceNormalC.x, sourceNormalC.y, sourceNormalC.z, sourceNormalC.magnitude, tcCU, tcCV);
            } else if (i_410_ == 1) {
                TriangleNormal triangleNormal = model.triangleNormals[sourceTriangleIndex];
                long l = ((long) ((i_340_ << 2) + (triangleNormal.x > 0 ? 1024 : 2048) + (triangleNormal.y + 256 << 12) + (triangleNormal.z + 256 << 22)) + (((long) (i_349_ << 24) + (long) (sourceColour << 8) + (long) sourceAlpha) << 32));
                triangleA[destTriangleIdx] = addVertex(model, model.triangleA[sourceTriangleIndex], l, triangleNormal.x, triangleNormal.y, triangleNormal.z, 0, tcAU, tcAV);
                triangleB[destTriangleIdx] = addVertex(model, model.triangleB[sourceTriangleIndex], l + (long) i_347_, triangleNormal.x, triangleNormal.y, triangleNormal.z, 0, tcBU, tcBV);
                triangleC[destTriangleIdx] = addVertex(model, model.triangleC[sourceTriangleIndex], l + (long) i_348_, triangleNormal.x, triangleNormal.y, triangleNormal.z, 0, tcCU, tcCV);
            }
            if (model.triangleTexture != null)
                triangleTexture[destTriangleIdx] = model.triangleTexture[sourceTriangleIndex];
            else
                triangleTexture[destTriangleIdx] = (short) -1;
            if (triangleTSkin != null)
                triangleTSkin[destTriangleIdx] = (byte) model.triangleTSkin[sourceTriangleIndex];
            triangleColour[destTriangleIdx] = (short) model.triangleColour[sourceTriangleIndex];
            if (model.triangleAlpha != null)
                triangleAlpha[destTriangleIdx] = (byte) model.triangleAlpha[sourceTriangleIndex];
        }
        int i_416_ = 0;
        short i_417_ = -10000;
        for (int i_418_ = 0; i_418_ < triangleCount; i_418_++) {
            short i_419_ = triangleTexture[i_418_];
            if (i_419_ != i_417_) {
                i_416_++;
                i_417_ = i_419_;
            }
        }
        textureTriangles = new int[i_416_ + 1];
        i_416_ = 0;
        i_417_ = (short) -10000;
        for (int i_420_ = 0; i_420_ < triangleCount; i_420_++) {
            short i_421_ = triangleTexture[i_420_];
            if (i_421_ != i_417_) {
                textureTriangles[i_416_++] = i_420_;
                i_417_ = i_421_;
            }
        }
        textureTriangles[i_416_] = triangleCount;
        aLongArray5048 = null;
        normalX = subArray(normalX, this.vertexCount);
        normalY = subArray(normalY, this.vertexCount);
        normalZ = subArray(normalZ, this.vertexCount);
        normalMagnitude = subArray(normalMagnitude, this.vertexCount);
        textureU = subArray(textureU, this.vertexCount);
        textureV = subArray(textureV, this.vertexCount);
    }

    public ModelRendererGL method1860(boolean arg0, boolean arg1) {
        return method1907(arg0, arg1, aModelRendererGL_5051, aModelRendererGL_5049);
    }

    public static void method1916(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, float[] arg6, int arg7, float arg8) {
        arg0 -= arg3;
        arg1 -= arg4;
        arg2 -= arg5;
        float f = ((float) arg0 * arg6[0] + (float) arg1 * arg6[1] + (float) arg2 * arg6[2]);
        float f_422_ = ((float) arg0 * arg6[3] + (float) arg1 * arg6[4] + (float) arg2 * arg6[5]);
        float f_423_ = ((float) arg0 * arg6[6] + (float) arg1 * arg6[7] + (float) arg2 * arg6[8]);
        float f_424_ = (float) Math.sqrt((double) (f * f + f_422_ * f_422_ + f_423_ * f_423_));
        float f_425_ = ((float) Math.atan2((double) f, (double) f_423_) / 6.2831855F + 0.5F);
        float f_426_ = ((float) Math.asin((double) (f_422_ / f_424_)) / 3.1415927F + 0.5F + arg8);
        if (arg7 == 1) {
            float f_427_ = f_425_;
            f_425_ = -f_426_;
            f_426_ = f_427_;
        } else if (arg7 == 2) {
            f_425_ = -f_425_;
            f_426_ = -f_426_;
        } else if (arg7 == 3) {
            float f_428_ = f_425_;
            f_425_ = f_426_;
            f_426_ = -f_428_;
        }
        aFloat5062 = f_425_;
        aFloat5058 = f_426_;
    }

    public int getBoundsLeft() {
        if (!bounds.upToDate)
            updateBounds();
        return bounds.minX;
    }

    public void transformStep(int opcode, int[] skinList, int vXOff, int vYOff, int vZOff, boolean transformNormals) {
        int skinListCount = skinList.length;
        if (opcode == 0) {
            vXOff <<= 4;
            vYOff <<= 4;
            vZOff <<= 4;
            int i_429_ = 0;
            vertexXModifier = 0;
            vertexYModifier = 0;
            vertexZModifier = 0;
            for (int i_430_ = 0; i_430_ < skinListCount; i_430_++) {
                int vskinID = skinList[i_430_];
                if (vskinID < vertexSkin.length) {
                    int[] is = vertexSkin[vskinID];
                    for (int i_432_ = 0; i_432_ < is.length; i_432_++) {
                        int i_433_ = is[i_432_];
                        vertexXModifier += vertexX[i_433_];
                        vertexYModifier += vertexY[i_433_];
                        vertexZModifier += vertexZ[i_433_];
                        i_429_++;
                    }
                }
            }
            if (i_429_ > 0) {
                vertexXModifier = vertexXModifier / i_429_ + vXOff;
                vertexYModifier = vertexYModifier / i_429_ + vYOff;
                vertexZModifier = vertexZModifier / i_429_ + vZOff;
            } else {
                vertexXModifier = vXOff;
                vertexYModifier = vYOff;
                vertexZModifier = vZOff;
            }
        } else if (opcode == 1) {
            vXOff <<= 4;
            vYOff <<= 4;
            vZOff <<= 4;
            for (int i_434_ = 0; i_434_ < skinListCount; i_434_++) {
                int i_435_ = skinList[i_434_];
                if (i_435_ < vertexSkin.length) {
                    int[] is = vertexSkin[i_435_];
                    for (int i_436_ = 0; i_436_ < is.length; i_436_++) {
                        int i_437_ = is[i_436_];
                        vertexX[i_437_] += vXOff;
                        vertexY[i_437_] += vYOff;
                        vertexZ[i_437_] += vZOff;
                    }
                }
            }
        } else if (opcode == 2) {
            for (int i_438_ = 0; i_438_ < skinListCount; i_438_++) {
                int i_439_ = skinList[i_438_];
                if (i_439_ < vertexSkin.length) {
                    int[] is = vertexSkin[i_439_];
                    for (int i_440_ = 0; i_440_ < is.length; i_440_++) {
                        int i_441_ = is[i_440_];
                        vertexX[i_441_] -= vertexXModifier;
                        vertexY[i_441_] -= vertexYModifier;
                        vertexZ[i_441_] -= vertexZModifier;
                        if (vZOff != 0) {
                            int i_442_ = Rasterizer.SINE[vZOff];
                            int i_443_ = Rasterizer.COSINE[vZOff];
                            int i_444_ = ((vertexY[i_441_] * i_442_ + vertexX[i_441_] * i_443_ + 32767) >> 16);
                            vertexY[i_441_] = ((vertexY[i_441_] * i_443_ - vertexX[i_441_] * i_442_ + 32767) >> 16);
                            vertexX[i_441_] = i_444_;
                        }
                        if (vXOff != 0) {
                            int i_445_ = Rasterizer.SINE[vXOff];
                            int i_446_ = Rasterizer.COSINE[vXOff];
                            int i_447_ = ((vertexY[i_441_] * i_446_ - vertexZ[i_441_] * i_445_ + 32767) >> 16);
                            vertexZ[i_441_] = ((vertexY[i_441_] * i_445_ + vertexZ[i_441_] * i_446_ + 32767) >> 16);
                            vertexY[i_441_] = i_447_;
                        }
                        if (vYOff != 0) {
                            int i_448_ = Rasterizer.SINE[vYOff];
                            int i_449_ = Rasterizer.COSINE[vYOff];
                            int i_450_ = ((vertexZ[i_441_] * i_448_ + vertexX[i_441_] * i_449_ + 32767) >> 16);
                            vertexZ[i_441_] = ((vertexZ[i_441_] * i_449_ - vertexX[i_441_] * i_448_ + 32767) >> 16);
                            vertexX[i_441_] = i_450_;
                        }
                        vertexX[i_441_] += vertexXModifier;
                        vertexY[i_441_] += vertexYModifier;
                        vertexZ[i_441_] += vertexZModifier;
                    }
                }
            }
            if (transformNormals && normalX != null) {
                for (int i_451_ = 0; i_451_ < skinListCount; i_451_++) {
                    int i_452_ = skinList[i_451_];
                    if (i_452_ < vertexSkin.length) {
                        int[] is = vertexSkin[i_452_];
                        for (int i_453_ = 0; i_453_ < is.length; i_453_++) {
                            int i_454_ = is[i_453_];
                            int i_455_ = vertexUsageCount[i_454_];
                            int i_456_ = vertexUsageCount[i_454_ + 1];
                            for (int i_457_ = i_455_; i_457_ < i_456_; i_457_++) {
                                int i_458_ = vertexIndexes[i_457_] - 1;
                                if (i_458_ == -1)
                                    break;
                                if (vZOff != 0) {
                                    int i_459_ = Rasterizer.SINE[vZOff];
                                    int i_460_ = Rasterizer.COSINE[vZOff];
                                    int i_461_ = ((normalY[i_458_] * i_459_ + normalX[i_458_] * i_460_ + 32767) >> 16);
                                    normalY[i_458_] = (short) (((normalY[i_458_] * i_460_) - (normalX[i_458_] * i_459_) + 32767) >> 16);
                                    normalX[i_458_] = (short) i_461_;
                                }
                                if (vXOff != 0) {
                                    int i_462_ = Rasterizer.SINE[vXOff];
                                    int i_463_ = Rasterizer.COSINE[vXOff];
                                    int i_464_ = ((normalY[i_458_] * i_463_ - normalZ[i_458_] * i_462_ + 32767) >> 16);
                                    normalZ[i_458_] = (short) (((normalY[i_458_] * i_462_) + (normalZ[i_458_] * i_463_) + 32767) >> 16);
                                    normalY[i_458_] = (short) i_464_;
                                }
                                if (vYOff != 0) {
                                    int i_465_ = Rasterizer.SINE[vYOff];
                                    int i_466_ = Rasterizer.COSINE[vYOff];
                                    int i_467_ = ((normalZ[i_458_] * i_465_ + normalX[i_458_] * i_466_ + 32767) >> 16);
                                    normalZ[i_458_] = (short) (((normalZ[i_458_] * i_466_) - (normalX[i_458_] * i_465_) + 32767) >> 16);
                                    normalX[i_458_] = (short) i_467_;
                                }
                            }
                        }
                    }
                }
                if (vertexNormals != null)
                    vertexNormals.upToDate = false;
            }
        } else if (opcode == 3) {
            for (int i_468_ = 0; i_468_ < skinListCount; i_468_++) {
                int i_469_ = skinList[i_468_];
                if (i_469_ < vertexSkin.length) {
                    int[] is = vertexSkin[i_469_];
                    for (int i_470_ = 0; i_470_ < is.length; i_470_++) {
                        int i_471_ = is[i_470_];
                        vertexX[i_471_] -= vertexXModifier;
                        vertexY[i_471_] -= vertexYModifier;
                        vertexZ[i_471_] -= vertexZModifier;
                        vertexX[i_471_] = vertexX[i_471_] * vXOff >> 7;
                        vertexY[i_471_] = vertexY[i_471_] * vYOff >> 7;
                        vertexZ[i_471_] = vertexZ[i_471_] * vZOff >> 7;
                        vertexX[i_471_] += vertexXModifier;
                        vertexY[i_471_] += vertexYModifier;
                        vertexZ[i_471_] += vertexZModifier;
                    }
                }
            }
        } else if (opcode == 5 && triangleSkin != null && triangleAlpha != null) {
            for (int i_472_ = 0; i_472_ < skinListCount; i_472_++) {
                int i_473_ = skinList[i_472_];
                if (i_473_ < triangleSkin.length) {
                    int[] is = triangleSkin[i_473_];
                    for (int i_474_ = 0; i_474_ < is.length; i_474_++) {
                        int i_475_ = is[i_474_];
                        int i_476_ = (triangleAlpha[i_475_] & 0xff) + vXOff * 8;
                        if (i_476_ < 0)
                            i_476_ = 0;
                        else if (i_476_ > 255)
                            i_476_ = 255;
                        triangleAlpha[i_475_] = (byte) i_476_;
                    }
                    if (is.length > 0)
                        vertexColours.upToDate = false;
                }
            }
        }
    }

    public void method1918() {
        if (normalX == null)
            rotateCW();
        else {
            for (int i = 0; i < realVertexCount; i++) {
                int i_477_ = vertexX[i];
                vertexX[i] = vertexZ[i];
                vertexZ[i] = -i_477_;
            }
            for (int i = 0; i < vertexCount; i++) {
                int i_478_ = normalX[i];
                normalX[i] = normalZ[i];
                normalZ[i] = (short) -i_478_;
            }
            bounds.upToDate = false;
            vertexPositions.upToDate = false;
            if (vertexNormals != null)
                vertexNormals.upToDate = false;
        }
    }

    public void method1919(short arg0, short arg1) {
        for (int i = 0; i < triangleCount; i++) {
            if (triangleColour[i] == arg0)
                triangleColour[i] = arg1;
        }
        vertexColours.upToDate = false;
    }

    public boolean method1784() {
        return (aBoolean5009 && vertexX != null && normalX != null);
    }

    public boolean method1920(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4)
            return false;
        if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4)
            return false;
        if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7)
            return false;
        if (arg0 > arg5 && arg0 > arg6 && arg0 > arg7)
            return false;
        return true;
    }

    public static void method1921(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, float[] arg6, float arg7, int arg8, float arg9) {
        arg0 -= arg3;
        arg1 -= arg4;
        arg2 -= arg5;
        float f = ((float) arg0 * arg6[0] + (float) arg1 * arg6[1] + (float) arg2 * arg6[2]);
        float f_479_ = ((float) arg0 * arg6[3] + (float) arg1 * arg6[4] + (float) arg2 * arg6[5]);
        float f_480_ = ((float) arg0 * arg6[6] + (float) arg1 * arg6[7] + (float) arg2 * arg6[8]);
        float f_481_ = ((float) Math.atan2((double) f, (double) f_480_) / 6.2831855F + 0.5F);
        if (arg7 != 1.0F)
            f_481_ *= arg7;
        float f_482_ = f_479_ + 0.5F + arg9;
        if (arg8 == 1) {
            float f_483_ = f_481_;
            f_481_ = -f_482_;
            f_482_ = f_483_;
        } else if (arg8 == 2) {
            f_481_ = -f_481_;
            f_482_ = -f_482_;
        } else if (arg8 == 3) {
            float f_484_ = f_481_;
            f_481_ = f_482_;
            f_482_ = -f_484_;
        }
        aFloat5064 = f_481_;
        aFloat5060 = f_482_;
    }

    static {
        anIntArray5057 = new int[1];
    }
}
