import time

class BatchInfo:
    appId:str=None
    batchTime:int=None
    submissionTime:int=-1
    processingStartTime:int=-1
    processingEndTime:int=-1

    def __init__(self, appId:str,batchTime:int=time.time()):
        self.appId = appId
        self.batchTime = batchTime

    def __str__(self):
        return "a"
        #return "BatchInfo({},{},{},{},{})".format(self.appId,self.batchTime,self.submissionTime,
        #self.processingStartTime,self.processingEndTime)

if __name__ == "__main__":
    b1=BatchInfo("app1")
    print(b1)

# def submit_batch():
#     # batchs.append()

# def complete_batch():