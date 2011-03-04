create index IX_D00C5D4 on MultiDevice_Rule (companyId, groupId);
create index IX_56051DFE on MultiDevice_Rule (companyId, groupId, action);
create index IX_8F40A46D on MultiDevice_Rule (companyId, groupId, layoutId);
create index IX_1E6D5397 on MultiDevice_Rule (companyId, groupId, layoutId, action);
create index IX_A7D352C7 on MultiDevice_Rule (companyId, groupId, layoutId, brand, model, os, osVersion, browser, browserVersion, pointingMethod, tablet, qwertyKeyboad);