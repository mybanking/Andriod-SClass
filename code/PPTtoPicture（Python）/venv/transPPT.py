import win32com
import win32com.client
import os
import sys

from PIL import Image

def ppt2png(ppt_path):
    """
    :param ppt_path: ppt 文件的绝对路径
    :return:
    """
    if os.path.exists(ppt_path):
        output_path = output_file(ppt_path)  # 判断文件是否存在

        ppt_app = win32com.client.Dispatch('PowerPoint.Application')
        ppt = ppt_app.Presentations.Open(ppt_path)  # 打开 ppt
        ppt.SaveAs(output_path, 17)  # 17数字是转为 ppt 转为图片
        ppt_app.Quit()  # 关闭资源，退出

    else:
        raise Exception('请检查文件是否存在！\n')


def output_file(ppt_path):
    """ 输出图片路径 """
    file_name = os.path.basename(ppt_path)  # 获取文件名字
    if file_name.endswith(('ppt', 'pptx')):
        exec_path = os.path.abspath(os.path.dirname(__file__))  # 当前脚本路径
        name = file_name.split('.')[0]  # 去除后缀，获取名字
        image_dir_path = os.path.join(exec_path, name)  # 图片文件夹的绝对路径
        if not os.path.exists(image_dir_path):
            os.makedirs(image_dir_path)  # 创建以 ppt 命名的图片文件夹
        output_png_path = os.path.join(image_dir_path, 'output.png')  # png 图片输出路径
        return output_png_path
    else:
        raise Exception('请检查后缀是否为 ppt/pptx 后缀！\n')


if __name__ == '__main__':
    # a = []
    # for i in range(1, len(sys.argv)):
    #        a.append((str(sys.argv[i])))
    # print(a[0])
    ppt2png("C:\\Users\\hp\\Desktop\\image\\test.ppt")
    # ppt2png(a[0])